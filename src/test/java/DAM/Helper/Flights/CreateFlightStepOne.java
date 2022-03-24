package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepOneParams;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightStepOne {
    String[] flightStepOne;

    public CreateFlightStepOne() throws JSONException {
        flightStepOne = new String[6];
        String body = new CreateFlightStepOneParams().getFlight();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given()
                .body(body)
                .when()
                .post()
                .then().extract().response();

        flightStepOne[0] = response.path("name");
        flightStepOne[1] = response.path("status");
        flightStepOne[2] = response.path("purpose");
        flightStepOne[3] = response.path("frequency.term");
        flightStepOne[4] = response.path("createdBy");
        flightStepOne[5] = response.path("id");
    }

    public String[] getFlightStepOne() {
        return flightStepOne;
    }
}
