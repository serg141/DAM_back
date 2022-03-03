package DAM.Flights;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepOneParams;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightStepOne {
    private final String id;

    public CreateFlightStepOne() throws JSONException {
        String logIn = new LogIn().logIn();
        String body = new CreateFlightStepOneParams().getFlight();

        String flights = new EndPoints().getFlights();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(flights)
                .then().statusCode(200)
                .extract().response();

        id = response.path("id").toString();
    }

    public String getId() {
        return id;
    }
}
