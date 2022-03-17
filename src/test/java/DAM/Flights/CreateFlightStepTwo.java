package DAM.Flights;

import DAM.Parametrs.Flights.CreateFlightStepTwoParams;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightStepTwo {
    String[] flightStepTwo;

    public CreateFlightStepTwo() throws JSONException {
        flightStepTwo = new String[9];
        String id = new CreateFlightStepOne().getFlightStepOne()[5];
        String body = new CreateFlightStepTwoParams().getFlight();

        Response response = given()
                .body(body)
                .when()
                .post(id + "/placement/")
                .then().extract().response();

        LinkedHashMap<String,Object> locations = response.path("locations[0]");
        LinkedHashMap<String,Object> positions = response.path("locations[0].positions[0]");
        LinkedHashMap<String,Object> formats = response.path("locations[0].positions[0].formats[0]");

        flightStepTwo[0] = response.path("name");
        flightStepTwo[1] = response.path("code");
        flightStepTwo[2] = locations.get("name").toString();
        flightStepTwo[3] = locations.get("code").toString();
        flightStepTwo[4] = positions.get("name").toString();
        flightStepTwo[5] = positions.get("code").toString();
        flightStepTwo[6] = formats.get("name").toString();
        flightStepTwo[7] = formats.get("code").toString();
        flightStepTwo[8] = id;
    }

    public String[] getFlightStepTwo() {
        return flightStepTwo;
    }
}
