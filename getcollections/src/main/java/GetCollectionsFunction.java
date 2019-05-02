import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GetCollectionsFunction implements RequestHandler<RequestClass, CharityCollections> {
    @Override
    public CharityCollections handleRequest(RequestClass input, Context context) {
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

        List<CharityCollection> result = new ArrayList<CharityCollection>();

        try {
            ItemCollection<ScanOutcome> items = table.scan( new ScanFilter("charityEmailId").eq(input.getCharityEmailId()), new ScanFilter("currentStatus").eq("Confirmed By Both"));
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                result.add(new CharityCollection(item.get("userName").toString(),
                        item.get("item").toString(),
                        item.get("quantity").toString(),
                        item.get("lastUpdateDate").toString()
                ));
            }

            result.sort(new Comparator<CharityCollection>() {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                @Override
                public int compare(CharityCollection object1, CharityCollection object2) {
                    try {
                        int flag = dateFormat.parse(object1.lastUpdateDate).compareTo(dateFormat.parse(object2.lastUpdateDate));
                        if(flag != 0) return -flag;
                        return dateFormat.parse(object1.lastUpdateDate).compareTo(dateFormat.parse(object2.lastUpdateDate));
                    } catch (ParseException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });


            return  new CharityCollections(result);
        } catch (Exception e) {
            //System.err.println("Create items failed.");
            System.err.println(e.getMessage());
            return  new CharityCollections(result);
        }
    }
}
