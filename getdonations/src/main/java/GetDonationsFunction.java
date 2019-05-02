import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetDonationsFunction implements RequestHandler<RequestClass, Donation>  {
    @Override
    public Donation handleRequest(RequestClass input, Context context) {
        //context.getLogger().log("Input: " + input);
        DynamoDB dynamoDB = new DynamoDB(AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder
                                .EndpointConfiguration("dynamodb.ap-south-1.amazonaws.com",
                                "ap-south-1"
                        )
                ).build()
        );
        Table table = dynamoDB.getTable("on_going_transactions");

        List<UserDonations> result = new ArrayList<UserDonations>();

        try {
            ItemCollection<ScanOutcome> items = table.scan( new ScanFilter("userEmailId").eq(input.getUserEmailId()), new ScanFilter("currentStatus").eq("Confirmed By Both"));
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                result.add(new UserDonations(item.get("charityName").toString(),
                        item.get("item").toString(),
                        item.get("lastUpdateDate").toString()
                ));
            }

            result.sort(new Comparator<UserDonations>() {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                @Override
                public int compare(UserDonations object1, UserDonations object2) {
                    try {
                        int flag = dateFormat.parse(object1.lastUpdateDate).compareTo(dateFormat.parse(object2.lastUpdateDate));
                        if(flag != 0) return -flag;
                        return dateFormat.parse(object1.lastUpdateDate).compareTo(dateFormat.parse(object2.lastUpdateDate));
                    } catch (ParseException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });


            return  new Donation(result);
        } catch (Exception e) {
            //System.err.println("Create items failed.");
            System.err.println(e.getMessage());
            return  new Donation(result);
        }
    }
}
