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

public class RegisterCharityFunction implements RequestHandler<RegisterCharity, ResponseClass> {
    @Override
    public ResponseClass handleRequest(RegisterCharity input, Context context) {
        //context.getLogger().log("Input: " + input);
        DynamoDB dynamoDB = new DynamoDB(AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder
                                .EndpointConfiguration("dynamodb.ap-south-1.amazonaws.com",
                                "ap-south-1"
                        )
                ).build()
        );
        Table table = dynamoDB.getTable("charity_details");

        try {
            final Item item = new Item()
                    .withPrimaryKey("emailId", input.getEmailId())
                    .withString("name", input.getName())
                    .withString("lat", input.getLat())
                    .withString("lng", input.getLng())
                    .withString("address", input.getAddress())
                    .withString("city", input.getCity())
                    .withString("pinCode", input.getPinCode())
                    .withString("phoneNumber", input.getPhoneNumber())
                    .withString("type", input.getType())
                    .withString("registerationNumber", input.getRegisterationNumber())
                    .withString("dateOfEstablishment", input.getdateOfEstablishment())
                    .withString("password", input.getPassword())
                    .withString("registerationCertificateImage", input.getRegisterationCertificateImage())
                    .withString("bannerImage", input.getbannerImage())
                    .withString("image1", input.getimage1())
                    .withString("pickupRadius", input.getPickupRadius())
                    .withString("numberOfResidents", input.getNumberOfResidents())
                    .withString("residentGender", input.getResidentGender())
                    .withBoolean("isVerified", input.getVerified());

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
