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

public class UserGetNotificationsFunction implements RequestHandler<RequestClass, UserNotifications> {
    @Override
    public UserNotifications handleRequest(RequestClass input, Context context) {
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

        List<UserNotification> result = new ArrayList<UserNotification>();

        try {
            ItemCollection<ScanOutcome> items = table.scan( new ScanFilter("userEmailId").eq(input.getUserEmailId()), new ScanFilter("isCancelledByUser").eq(false));
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                if(!(Boolean.parseBoolean(item.get("isCompletedByUser").toString()) && Boolean.parseBoolean(item.get("isCompletedByCharity").toString()))) {
                    result.add(new UserNotification(item.get("charityName").toString(),
                            item.get("charityEmailId").toString(),
                            item.get("charityLat").toString(),
                            item.get("charityLng").toString(),
                            item.get("charityAddress").toString(),
                            item.get("charityPhoneNumber").toString(),
                            Boolean.parseBoolean(item.get("isCompletedByUser").toString()),
                            item.get("item").toString(),
                            item.get("quantity").toString(),
                            item.get("transactionType").toString(),
                            item.get("currentStatus").toString()
                    ));
                }
            }

            return  new UserNotifications(result);
        } catch (Exception e) {
            //System.err.println("Create items failed.");
            System.err.println(e.getMessage());
            return  new UserNotifications(result);
        }
    }
}
