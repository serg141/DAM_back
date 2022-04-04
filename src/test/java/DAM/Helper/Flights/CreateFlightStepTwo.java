package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepTwoParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepTwo {
    private ArrayList<String> flightStepTwo = new ArrayList<>();

    public CreateFlightStepTwo() throws JSONException {
        String id = new CreateFlightStepOne().getFlightStepOne().get(5);
        String body = new CreateFlightStepTwoParams().getFlight();

        Response response = given().body(body).when().post(id + "/placement/").then().extract().response();

        flightStepTwo.add(response.path("name"));
        flightStepTwo.add(response.path("code"));
        flightStepTwo.add(response.path("locations[0].name"));
        flightStepTwo.add(response.path("locations[0].code"));
        flightStepTwo.add(response.path("locations[0].positions[0].name"));
        flightStepTwo.add(response.path("locations[0].positions[0].code"));
        flightStepTwo.add(response.path("locations[0].positions[0].formats[0].name"));
        flightStepTwo.add(response.path("locations[0].positions[0].formats[0].code"));
        flightStepTwo.add(id);
    }
}
