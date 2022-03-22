package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class GetSegmentsTech {
    String[] segmentsTech;

    public GetSegmentsTech() throws JSONException {
        segmentsTech = new String[4];

        String id = new CreateFlightWithTechParameters().getFlightStepFour()[6];

        Response response = given().when().get(id + "/segments/tech").then().extract().response();

        if(response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b")) {
            if(response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"))
            {
                if(response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a")) {
                    segmentsTech[0] = response.path("selections[1].categoryUuid");
                    segmentsTech[1] = response.path("selections[1].filters.fromAppVer");
                    segmentsTech[2] = response.path("selections[1].filters.toAppVer");
                    segmentsTech[3] = response.path("selections[0].categoryUuid");
                }
            }
        }
    }

    public String[] getSegmentsTech() {
        return segmentsTech;
    }
}
