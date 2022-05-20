package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFivePreroll;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepFivePrerollNone {
    private ArrayList<String> flightStepFivePrerollNone = new ArrayList<>();

    public CreateFlightStepFivePrerollNone() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFivePreroll().getFlightHideableTypeNone();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post(ids.get(0) + "/creatives").then().extract().response();

        if (!(Boolean) response.path("pages[0].showCross")) {
            flightStepFivePrerollNone.add(response.path("pages[0].pageName"));
            flightStepFivePrerollNone.add(response.path("pages[0].hideableType"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].url"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].type"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].link.linkAddress"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].link.linkType"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[1].value"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[1].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[1].type"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[2].value"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[2].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[2].type"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].value"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].type"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].link.linkAddress"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].link.linkType"));

            flightStepFivePrerollNone.add(response.path("name"));
            flightStepFivePrerollNone.add(response.path("theme"));
            flightStepFivePrerollNone.add(response.path("offerType"));

            flightStepFivePrerollNone.add(ids.get(0));
        }
    }
}
