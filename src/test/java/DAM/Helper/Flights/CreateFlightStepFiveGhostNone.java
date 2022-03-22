package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveGhost;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightStepFiveGhostNone {
    String[] flightStepFiveGhostNone;

    public CreateFlightStepFiveGhostNone() throws JSONException {
        flightStepFiveGhostNone = new String[23];
        String[] ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveGhost().getFlightHideableTypeNone();
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
        LinkedHashMap<String,Object> elementBlock = response.path("pages[0].elements[3]");

        if(!(Boolean) pages.get("showCross")) {
            flightStepFiveGhostNone[0] = pages.get("pageName").toString();
            flightStepFiveGhostNone[1] = pages.get("hideableType").toString();

            flightStepFiveGhostNone[2] = elementImage.get("url").toString();
            flightStepFiveGhostNone[3] = elementImage.get("elementId").toString();
            flightStepFiveGhostNone[4] = elementImage.get("type").toString();
            flightStepFiveGhostNone[5] = response.path("pages[0].elements[0].link.linkAddress");
            flightStepFiveGhostNone[6] = response.path("pages[0].elements[0].link.linkType");

            flightStepFiveGhostNone[7] = elementHeading.get("value").toString();
            flightStepFiveGhostNone[8] = elementHeading.get("elementId").toString();
            flightStepFiveGhostNone[9] = elementHeading.get("type").toString();

            flightStepFiveGhostNone[10] = elementDescription.get("value").toString();
            flightStepFiveGhostNone[11] = elementDescription.get("elementId").toString();
            flightStepFiveGhostNone[12] = elementDescription.get("type").toString();

            flightStepFiveGhostNone[13] = elementBlock.get("elementId").toString();
            flightStepFiveGhostNone[14] = elementBlock.get("type").toString();
            flightStepFiveGhostNone[15] = response.path("pages[0].elements[3].link.linkAddress");
            flightStepFiveGhostNone[16] = response.path("pages[0].elements[3].link.linkType");
            flightStepFiveGhostNone[17] = response.path("pages[0].elements[3].style.code");
            flightStepFiveGhostNone[18] = response.path("pages[0].elements[3].style.backGroundColor");
            flightStepFiveGhostNone[19] = response.path("pages[0].elements[3].style.fontColor");

            flightStepFiveGhostNone[20] = response.path("name");
            flightStepFiveGhostNone[21] = response.path("theme");
            flightStepFiveGhostNone[22] = response.path("offerType");
        }
    }

    public String[] getFlightStepFiveGhostNone() {
        return flightStepFiveGhostNone;
    }
}
