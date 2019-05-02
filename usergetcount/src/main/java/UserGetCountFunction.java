import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.Select;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Iterator;

public class UserGetCountFunction implements RequestHandler<RequestClass,ResponseClass> {
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
        Table table = dynamoDB.getTable("user_details");

        try {
            Integer userCount = 0;
            ItemCollection<ScanOutcome> items = table.scan( new ScanFilter("emailId").exists());
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                userCount++;
            }

            return new ResponseClass(userCount.toString());
        }
        catch (Exception e) {
            //System.err.println("GetItem failed.");
            System.err.println(e.getMessage());
            return new ResponseClass(false);
        }
    }
}
