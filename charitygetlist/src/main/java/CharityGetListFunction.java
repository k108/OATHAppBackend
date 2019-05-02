import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CharityGetListFunction implements RequestHandler<RequestClass,ResponseClass> {
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

        List<CharityPreview> result = new ArrayList<CharityPreview>();

        try {
            ItemCollection<ScanOutcome> items = table.scan( new ScanFilter("city").eq(input.getUserCity()));
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                Double distance= distance(Double.parseDouble(input.getUserLat()),
                        Double.parseDouble(item.get("lat").toString()),
                        Double.parseDouble(input.getUserLng()),
                        Double.parseDouble(item.get("lng").toString()),
                        0.0,
                        0.0);
                distance = Double.parseDouble(String.format("%.1f", distance/1000));

                result.add(new CharityPreview(item.get("name").toString(),
                        item.getString("emailId"),
                        item.getString("type"),
                        item.getString("bannerImage"),
                        item.getString("numberOfResidents"),
                        Double.toString(distance),
                        item.getBoolean("isVerified")
                        ));
            }

            result.sort(new Comparator<CharityPreview>() {
                @Override
                public int compare(CharityPreview object1, CharityPreview object2) {

                    if(Double.parseDouble(object1.distance) > Double.parseDouble(object2.distance)){
                        return 1;
                    }else if(Double.parseDouble(object1.distance) == Double.parseDouble(object2.distance)){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            });

            return  new ResponseClass(result);

        }
        catch(Exception e) {
            //System.err.println("GetItem failed.");
            //System.err.println(e.getMessage());
            return new ResponseClass(result);
        }
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

}
