package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepThreeSocialParams;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateFlightWithAuthParameters {
    String[] flightStepThree;

    public CreateFlightWithAuthParameters() throws JSONException {
        flightStepThree = new String[4];
        String body = new CreateFlightStepThreeSocialParams().getFlight();
        String id = new CreateFlightStepTwo().getFlightStepTwo()[8];

        Response response = given()
                .body(body)
                .when()
                .post(id + "/segments/social")
                .then().extract().response();

        if (response.path("segmentIdsMap.26a42f93-7499-4c4a-9fee-0cfba8309d15")) {
            List<String> specialParams = response.path("specialParams");
            LinkedHashMap<String,Object> selections = response.path("selections[0]");
            flightStepThree[0] = selections.get("categoryUuid").toString();
            flightStepThree[1] = specialParams.get(0);
            flightStepThree[2] = specialParams.get(1);
            flightStepThree[3] = id;
        }
    }

    public String[] getFlightStepThree() {
        return flightStepThree;
    }
}
