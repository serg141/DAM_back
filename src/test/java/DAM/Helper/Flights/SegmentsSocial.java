package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class SegmentsSocial {
    private ArrayList<String> segments = new ArrayList<>();

    public SegmentsSocial() throws JSONException {
        String id = new CreateFlightWithAuthParameters().getFlightStepThree().get(3);

        Response response = given().when().get(id + "/segments/social").then().extract().response();

        if(response.path("segmentIdsMap.26a42f93-7499-4c4a-9fee-0cfba8309d15")) {
            segments.add(response.path("selections[0].categoryUuid"));
            segments.add(response.path("specialParams[0]"));
            segments.add(response.path("specialParams[1]"));
        }
    }
}
