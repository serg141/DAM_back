package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFourTechParams;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightWithTechParameters {
    String[] flightStepFour;

    public CreateFlightWithTechParameters() throws JSONException {
        flightStepFour = new String[7];
        String id = new CreateFlightWithAuthParameters().getFlightStepThree()[3];
        String body = new CreateFlightStepFourTechParams().getFlightWithParameters();

        Response response = given()
                .body(body)
                .when()
                .post(id + "/segments/tech")
                .then().extract().response();

        LinkedHashMap<String,Object> selections0 = response.path("selections[0]");
        LinkedHashMap<String,Object> selections1 = response.path("selections[1]");
        if(response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b")) {
            if(response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"))
            {
                if(response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a")) {
                    flightStepFour[0] = selections0.get("categoryUuid").toString();
                    flightStepFour[1] = response.path("selections[0].filters.fromAppVer");
                    flightStepFour[2] = response.path("selections[0].filters.toAppVer");
                    flightStepFour[3] = selections1.get("categoryUuid").toString();
                    flightStepFour[4] = response.path("selections[1].filters.fromAppVer");
                    flightStepFour[5] = response.path("selections[1].filters.toAppVer");
                    flightStepFour[6] = id;
                }
            }
        }
    }

    public String[] getFlightStepFour() {
        return flightStepFour;
    }
}
