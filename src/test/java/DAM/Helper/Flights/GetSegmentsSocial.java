package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class GetSegmentsSocial {
    String[] segments;

    public GetSegmentsSocial() throws JSONException {
        segments = new String[3];

        String id = new CreateFlightWithAuthParameters().getFlightStepThree()[3];

        Response response = given().when().get(id + "/segments/social").then().extract().response();

        if(response.path("segmentIdsMap.26a42f93-7499-4c4a-9fee-0cfba8309d15")) {
            segments[0] = response.path("selections[0].categoryUuid");
            segments[1] = response.path("specialParams[0]");
            segments[2] = response.path("specialParams[1]");
        }
    }
}
