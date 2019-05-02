import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RegisterUserFunction implements RequestHandler<RegisterUser, ResponseClass>{
    @Override
    public ResponseClass handleRequest(RegisterUser input, Context context) {
        //context.getLogger().log("Input: " + input);
        DynamoDB dynamoDB = new DynamoDB(AmazonDynamoDBClientBuilder
                                         .standard()
                                         .withEndpointConfiguration(new AwsClientBuilder
                                                                    .EndpointConfiguration("dynamodb.ap-south-1.amazonaws.com",
                                                                                           "ap-south-1"
                                                                                           )
                                                                    ).build()
                                         );
        Table table = dynamoDB.getTable("user_details");

        try {
            final Item item = new Item()
                    .withPrimaryKey("emailId", input.getEmailId())
                    .withString("name", input.getName())
                    .withString("lat", input.getLat())
                    .withString("lng", input.getLng())
                    .withString("address", input.getAddress())
                    .withString("city", input.getCity())
                    .withString("pinCode", input.getPinCode())
                    .withString("gender", input.getGender())
                    .withString("phoneNumber", input.getPhoneNumber())
                    .withString("dateOfBirth", input.getDateOfBirth());

            table.putItem(item);
            return new ResponseClass(true);
        }
        catch (Exception e) {
            //System.err.println("Create items failed.");
            //System.err.println(e.getMessage());
            return new ResponseClass(false);
        }
    }
}
