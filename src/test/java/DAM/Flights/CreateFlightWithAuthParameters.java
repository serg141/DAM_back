package DAM.Flights;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepThreeSocialParams;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightWithAuthParameters {
    String id;

    public CreateFlightWithAuthParameters() throws JSONException {
        String logIn = new LogIn().logIn();
        id = new CreateFlightStepTwo().getId();

        String flights = new EndPoints().getFlights();
        String body = new CreateFlightStepThreeSocialParams().getFlight();
        String segmentSocial = new EndPoints().getSegmentSocial();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(flights + id + segmentSocial)
                .then().statusCode(200);
    }

    public String getId() {
        return id;
    }
}
