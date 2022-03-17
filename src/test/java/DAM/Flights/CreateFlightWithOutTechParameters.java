package DAM.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFourTechParams;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightWithOutTechParameters {
    String[] flightStepFour;

    public CreateFlightWithOutTechParameters() throws JSONException {
        flightStepFour = new String[6];
        String id = new CreateFlightWithAuthParameters().getFlightStepThree()[3];
        String body = new CreateFlightStepFourTechParams().getFlightWithOutParameters();

        Response response = given()
                .body(body)
                .when()
                .post(id + "/segments/tech")
                .then().extract().response();

        LinkedHashMap<String,Object> selections0 = response.path("selections[0]");
        LinkedHashMap<String,Object> selections1 = response.path("selections[1]");

        flightStepFour[0] = selections0.get("categoryUuid").toString();
        flightStepFour[1] = selections0.get("filters").toString();
        flightStepFour[2] = selections1.get("categoryUuid").toString();
        flightStepFour[3] = selections1.get("filters").toString();
        flightStepFour[4] = response.path("segmentIdsMap").toString();
        flightStepFour[5] = id;
    }

    public String[] getFlightStepFour() {
        return flightStepFour;
    }
}
