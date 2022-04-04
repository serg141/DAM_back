package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveGhost;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepFiveGhostNone {
    private ArrayList<String> flightStepFiveGhostNone = new ArrayList<>();

    public CreateFlightStepFiveGhostNone() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveGhost().getFlightHideableTypeNone();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post(ids.get(0) + "/creatives").then().extract().response();

        if (!(Boolean) response.path("pages[0].showCross")) {
            flightStepFiveGhostNone.add(response.path("pages[0].pageName"));
            flightStepFiveGhostNone.add(response.path("pages[0].hideableType"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].url"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].type"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].link.linkAddress"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].link.linkType"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[1].value"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[1].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[1].type"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[2].value"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[2].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[2].type"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].type"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].link.linkAddress"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].link.linkType"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].style.code"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].style.backGroundColor"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].style.fontColor"));

            flightStepFiveGhostNone.add(response.path("name"));
            flightStepFiveGhostNone.add(response.path("theme"));
            flightStepFiveGhostNone.add(response.path("offerType"));
        }
    }
}
