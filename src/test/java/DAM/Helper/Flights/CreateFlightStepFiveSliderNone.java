package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveSlider;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightStepFiveSliderNone {
    String[] flightStepFiveSliderNone;

    public CreateFlightStepFiveSliderNone() throws JSONException {
        flightStepFiveSliderNone = new String[29];
        String[] ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveSlider().getFlightHideableTypeNone();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given()
                .body(body)
                .queryParam("placementId", ids[1])
                .when()
                .post(ids[0] + "/creatives")
                .then()
                .extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");
        LinkedHashMap<String,Object> elementHeading = response.path("pages[0].elements[0]");
        LinkedHashMap<String,Object> elementDescription = response.path("pages[0].elements[1]");
        LinkedHashMap<String,Object> elementBlock = response.path("pages[0].elements[2]");
        LinkedHashMap<String,Object> elementLabelBody = response.path("pages[0].elements[3]");
        LinkedHashMap<String,Object> elementLabelText = response.path("pages[0].elements[4]");
        LinkedHashMap<String,Object> elementButton = response.path("pages[0].elements[5]");

        if(!(Boolean) pages.get("showCross")) {
            flightStepFiveSliderNone[0] = pages.get("pageName").toString();
            flightStepFiveSliderNone[1] = pages.get("hideableType").toString();

            flightStepFiveSliderNone[2] = elementHeading.get("value").toString();
            flightStepFiveSliderNone[3] = elementHeading.get("elementId").toString();
            flightStepFiveSliderNone[4] = elementHeading.get("type").toString();

            flightStepFiveSliderNone[5] = elementDescription.get("value").toString();
            flightStepFiveSliderNone[6] = elementDescription.get("elementId").toString();
            flightStepFiveSliderNone[7] = elementDescription.get("type").toString();

            flightStepFiveSliderNone[8] = elementBlock.get("elementId").toString();
            flightStepFiveSliderNone[9] = elementBlock.get("type").toString();
            flightStepFiveSliderNone[10] = response.path("pages[0].elements[2].style.code");
            flightStepFiveSliderNone[11] = response.path("pages[0].elements[2].style.backGroundColor");
            flightStepFiveSliderNone[12] = response.path("pages[0].elements[2].style.fontColor");

            flightStepFiveSliderNone[13] = elementLabelBody.get("elementId").toString();
            flightStepFiveSliderNone[14] = elementLabelBody.get("type").toString();
            flightStepFiveSliderNone[15] = response.path("pages[0].elements[3].style.code");
            flightStepFiveSliderNone[16] = response.path("pages[0].elements[3].style.backGroundColor");
            flightStepFiveSliderNone[17] = response.path("pages[0].elements[3].style.fontColor");

            flightStepFiveSliderNone[18] = elementLabelText.get("elementId").toString();
            flightStepFiveSliderNone[19] = elementLabelText.get("value").toString();
            flightStepFiveSliderNone[20] = elementLabelText.get("type").toString();

            flightStepFiveSliderNone[21] = elementButton.get("value").toString();
            flightStepFiveSliderNone[22] = elementButton.get("elementId").toString();
            flightStepFiveSliderNone[23] = elementButton.get("type").toString();
            flightStepFiveSliderNone[24] = response.path("pages[0].elements[5].link.linkAddress");
            flightStepFiveSliderNone[25] = response.path("pages[0].elements[5].link.linkType");

            flightStepFiveSliderNone[26] = response.path("name");
            flightStepFiveSliderNone[27] = response.path("theme");
            flightStepFiveSliderNone[28] = response.path("offerType");
        }
    }

    public String[] getFlightStepFiveSliderNone() {
        return flightStepFiveSliderNone;
    }
}
