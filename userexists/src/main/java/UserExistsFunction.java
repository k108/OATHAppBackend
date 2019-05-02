import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UserExistsFunction implements RequestHandler<IdentifyUser,ResponseClass> {
    @Override
    public ResponseClass handleRequest(IdentifyUser input, Context context) {
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
            Item item = table.getItem("emailId", input.getEmailId());
            //System.out.println("Printing item after retrieving it....");
            //System.out.println(item.toJSONPretty());
            if(item == null){
                return new ResponseClass(false);
            }else {
                return new ResponseClass(true);
            }
        }
        catch (Exception e) {
            //System.err.println("GetItem failed.");
            //System.err.println(e.getMessage());
            return new ResponseClass(false);
        }
    }
}
