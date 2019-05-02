import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

public class IsCompletedByUserFunction implements RequestHandler<RequestClass, ResponseClass> {
    @Override
    public ResponseClass handleRequest(RequestClass input, Context context) {
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

        try {

            ItemCollection<ScanOutcome> items = table.scan(
                    new ScanFilter("userEmailId").eq(input.getUserEmailId()),
                    new ScanFilter("charityEmailId").eq(input.getCharityEmailId()),
                    new ScanFilter("item").eq(input.getItem()),
                    new ScanFilter("quantity").eq(input.getQuantity())
            );
            Iterator<Item> iterator = items.iterator();
            Item item = iterator.next();
            String id = item.get("id").toString();

            Boolean isCompletedByUser = true;
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dateObject = new Date();

            String lastUpdateDate = dateFormat.format(dateObject);
            String currentStatus = "";
            if(item.getBoolean("isCompletedByCharity") == true){
                currentStatus = "Confirmed By Both";
            }else {
                currentStatus = "Confirmed By User and Pending By Charity";
            }

            UpdateItemOutcome outcome = table.updateItem("id", id,
                    new AttributeUpdate("isCompletedByUser").put(isCompletedByUser),
                    new AttributeUpdate("lastUpdateDate").put(lastUpdateDate),
                    new AttributeUpdate("currentStatus").put(currentStatus)
            );

            // Check the response.
            //System.out.println("Printing item after conditional update to new attribute...");
            //System.out.println(outcome.getItem().toJSONPretty());

            return new ResponseClass(true);
        }
        catch (Exception e) {
                //System.err.println("Error updating item in " + tableName);
                //System.err.println(e.getMessage());
                return new ResponseClass(false);
        }
    }
}
