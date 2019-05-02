import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.UUID;

public class FillOnGoingTransactionFunction implements RequestHandler<FillOnGoingTransaction, ResponseClass> {
    @Override
        public ResponseClass handleRequest(FillOnGoingTransaction input, Context context) {
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

                final Item item = new Item()
                        .withPrimaryKey("id", input.getId())
                        .withString("userEmailId", input.getUserEmailId())
                        .withString("userName", input.getUserName())
                        .withString("userAddress", input.getUserAddress())
                        .withString("userLat", input.getUserLat())
                        .withString("userLng", input.getUserLng())
                        .withString("userPhoneNumber", input.getUserPhoneNumber())
                        .withString("charityName", input.getCharityName())
                        .withString("charityEmailId", input.getCharityEmailId())
                        .withString("charityLat", input.getCharityLat())
                        .withString("charityLng", input.getCharityLng())
                        .withString("charityAddress", input.getCharityAddress())
                        .withString("charityPhoneNumber", input.getCharityPhoneNumber())
                        .withString("item", input.getItem())
                        .withString("quantity", input.getQuantity())
                        .withBoolean("isCompletedByUser", input.getCompletedByUser())
                        .withBoolean("isCompletedByCharity", input.getCompletedByCharity())
                        .withBoolean("isCancelledByUser", input.getCancelledByUser())
                        .withString("cancelRemarksByUser", input.getCancelRemarksByUser())
                        .withString("lastUpdateDate", input.getLastUpdateDate())
                        .withString("transactionType", input.getTransactionType())
                        .withString("currentStatus", input.getCurrentStatus());

                table.putItem(item);
                return new ResponseClass(true);
            } catch (Exception e) {
                //System.err.println("Create items failed.");
                System.err.println(e.getMessage());
                return new ResponseClass(false);
            }
    }
}
