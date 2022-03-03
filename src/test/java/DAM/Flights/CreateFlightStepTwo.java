package DAM.Flights;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepTwoParams;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightStepTwo {
    String id;

    public CreateFlightStepTwo() throws JSONException {
        String logIn = new LogIn().logIn();
        id = new CreateFlightStepOne().getId();

        String flights = new EndPoints().getFlights();
        String body = new CreateFlightStepTwoParams().getFlight();
        String placement = new EndPoints().getPlacement();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(flights + id + placement)
                .then().statusCode(200);
    }

    public String getId() {
        return id;
    }
}
