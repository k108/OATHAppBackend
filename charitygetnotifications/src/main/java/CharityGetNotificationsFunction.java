import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CharityGetNotificationsFunction implements RequestHandler<RequestClass, CharityNotifications> {
    @Override
    public CharityNotifications handleRequest(RequestClass input, Context context) {
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

        List<CharityNotification> result = new ArrayList<CharityNotification>();

        try {
            ItemCollection<ScanOutcome> items = table.scan( new ScanFilter("charityEmailId").eq(input.getCharityEmailId()), new ScanFilter("isCancelledByUser").eq(false));
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                if(!(Boolean.parseBoolean(item.get("isCompletedByUser").toString()) && Boolean.parseBoolean(item.get("isCompletedByCharity").toString()))) {
                    result.add(new CharityNotification(item.get("userName").toString(),
                            item.get("userEmailId").toString(),
                            item.get("userLat").toString(),
                            item.get("userLng").toString(),
                            item.get("userAddress").toString(),
                            item.get("userPhoneNumber").toString(),
                            Boolean.parseBoolean(item.get("isCompletedByCharity").toString()),
                            item.get("item").toString(),
                            item.get("quantity").toString(),
                            item.get("transactionType").toString(),
                            item.get("currentStatus").toString()
                    ));
                }
            }

            return  new CharityNotifications(result);
        } catch (Exception e) {
            //System.err.println("Create items failed.");
            System.err.println(e.getMessage());
            return  new CharityNotifications(result);
        }
    }
}
