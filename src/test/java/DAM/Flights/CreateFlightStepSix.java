package DAM.Flights;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepFivePreroll;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightStepSix {
    String id, logIn, flights, creative, body, placementId;
    String[] ids;

    public CreateFlightStepSix() throws JSONException {
        logIn = new LogIn().logIn();
        ids = new GetPlacementId().getId();
        id = ids[0];
        placementId = ids[1];
        body = new CreateFlightStepFivePreroll().getFlightHideableTypeNone();

        flights = new EndPoints().getFlights();
        creative = new EndPoints().getCreative();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .queryParam("placementId", placementId)
                .when()
                .post(flights + id + creative);
    }

    public String getId() {
        return id;
    }
}
