import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CharityUpdatePasswordFunction implements RequestHandler<RequestClass,ResponseClass> {

    @Override
    public ResponseClass handleRequest(RequestClass input, Context context) {
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
            UpdateItemOutcome outcome = table.updateItem("emailId", input.getEmailId(), new AttributeUpdate("password").put(input.getPassword()));
            // Check the response.
            //System.out.println("Printing item after conditional update to new attribute...");
            //System.out.println(outcome.getItem().toJSONPretty());
            return new ResponseClass(true);
        }
        catch (Exception e) {
            //System.err.println("Error updating item in " + tableName);
            System.err.println(e.getMessage());
            return new ResponseClass(false);
        }
    }
}
