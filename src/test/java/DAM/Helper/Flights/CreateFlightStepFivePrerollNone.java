package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFivePreroll;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightStepFivePrerollNone {
    String[] flightStepFivePrerollNone;

    public CreateFlightStepFivePrerollNone() throws JSONException {
        flightStepFivePrerollNone = new String[22];
        String[] ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFivePreroll().getFlightHideableTypeNone();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given()
                .body(body)
                .queryParam("placementId", ids[1])
                .when()
                .post(ids[0] + "/creatives")
                .then()
                .extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");
        LinkedHashMap<String,Object> elementImage = response.path("pages[0].elements[0]");
        LinkedHashMap<String,Object> elementHeading = response.path("pages[0].elements[1]");
        LinkedHashMap<String,Object> elementDescription = response.path("pages[0].elements[2]");
        LinkedHashMap<String,Object> elementButton = response.path("pages[0].elements[3]");

        if(!(Boolean) pages.get("showCross")) {
            flightStepFivePrerollNone[0] = pages.get("pageName").toString();
            flightStepFivePrerollNone[1] = pages.get("hideableType").toString();

            flightStepFivePrerollNone[2] = elementImage.get("url").toString();
            flightStepFivePrerollNone[3] = elementImage.get("elementId").toString();
            flightStepFivePrerollNone[4] = elementImage.get("type").toString();
            flightStepFivePrerollNone[5] = response.path("pages[0].elements[0].link.linkAddress");
            flightStepFivePrerollNone[6] = response.path("pages[0].elements[0].link.linkType");

            flightStepFivePrerollNone[7] = elementHeading.get("value").toString();
            flightStepFivePrerollNone[8] = elementHeading.get("elementId").toString();
            flightStepFivePrerollNone[9] = elementHeading.get("type").toString();

            flightStepFivePrerollNone[10] = elementDescription.get("value").toString();
            flightStepFivePrerollNone[11] = elementDescription.get("elementId").toString();
            flightStepFivePrerollNone[12] = elementDescription.get("type").toString();

            flightStepFivePrerollNone[13] = elementButton.get("value").toString();
            flightStepFivePrerollNone[14] = elementButton.get("elementId").toString();
            flightStepFivePrerollNone[15] = elementButton.get("type").toString();
            flightStepFivePrerollNone[16] = response.path("pages[0].elements[3].link.linkAddress");
            flightStepFivePrerollNone[17] = response.path("pages[0].elements[3].link.linkType");

            flightStepFivePrerollNone[18] = response.path("name");
            flightStepFivePrerollNone[19] = response.path("theme");
            flightStepFivePrerollNone[20] = response.path("offerType");

            flightStepFivePrerollNone[21] = ids[0];
        }
    }

    public String[] getFlightStepFivePrerollNone() {
        return flightStepFivePrerollNone;
    }
}
