package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class SegmentsTech {
    private ArrayList<String> segmentsTech = new ArrayList<>();

    public SegmentsTech() throws JSONException {
        String id = new CreateFlightWithTechParameters().getFlightStepFour().get(6);

        Response response = given().when().get(id + "/segments/tech").then().extract().response();

        if(response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b")) {
            if(response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"))
            {
                if(response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a")) {
                    segmentsTech.add(response.path("selections[1].categoryUuid"));
                    segmentsTech.add(response.path("selections[1].filters.fromAppVer"));
                    segmentsTech.add(response.path("selections[1].filters.toAppVer"));
                    segmentsTech.add(response.path("selections[0].categoryUuid"));
                }
            }
        }
    }
}
