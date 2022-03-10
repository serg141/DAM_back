package DAM.Flights;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepFourTechParams;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightWithTechParameters {
    String id;

    public CreateFlightWithTechParameters() throws JSONException {
        String logIn = new LogIn().logIn();
        id = new CreateFlightWithAuthParameters().getId();

        String flights = new EndPoints().getFlights();
        String body = new CreateFlightStepFourTechParams().getFlightWithParameters();
        String segmentsTech = new EndPoints().getSegmentTech();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(flights + id + segmentsTech)
                .then().statusCode(200);
    }

    public String getId() {
        return id;
    }
}
