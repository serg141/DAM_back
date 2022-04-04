package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFourTechParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightWithTechParameters {
    ArrayList<String> flightStepFour = new ArrayList<>();

    public CreateFlightWithTechParameters() throws JSONException {
        String id = new CreateFlightWithAuthParameters().getFlightStepThree().get(3);
        String body = new CreateFlightStepFourTechParams().getFlightWithParameters();

        Response response = given().body(body).when().post(id + "/segments/tech").then().extract().response();

        if(response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b")) {
            if(response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"))
            {
                if(response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a")) {
                    flightStepFour.add(response.path("selections[0].categoryUuid"));
                    flightStepFour.add(response.path("selections[0].filters.fromAppVer"));
                    flightStepFour.add(response.path("selections[0].filters.toAppVer"));
                    flightStepFour.add(response.path("selections[1].categoryUuid"));
                    flightStepFour.add(response.path("selections[1].filters.fromAppVer"));
                    flightStepFour.add(response.path("selections[1].filters.toAppVer"));
                    flightStepFour.add(id);
                }
            }
        }
    }
}
