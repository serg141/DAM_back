package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepOneParams;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepOne {
    private ArrayList<String> flightStepOne = new ArrayList<>();

    public CreateFlightStepOne() throws JSONException {
        String body = new CreateFlightStepOneParams().getFlight();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given().body(body).when().post().then().extract().response();

        flightStepOne.add(response.path("name"));
        flightStepOne.add(response.path("status"));
        flightStepOne.add(response.path("purpose"));
        flightStepOne.add(response.path("frequency.term"));
        flightStepOne.add(response.path("createdBy"));
        flightStepOne.add(response.path("id"));
    }
}
