package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveSlider;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepFiveSliderNone {
    private ArrayList<String> flightStepFiveSliderNone = new ArrayList<>();

    public CreateFlightStepFiveSliderNone() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveSlider().getFlightHideableTypeNone();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post(ids.get(0) + "/creatives").then().extract().response();

        if (!(Boolean) response.path("pages[0].showCross")) {
            flightStepFiveSliderNone.add(response.path("pages[0].pageName"));
            flightStepFiveSliderNone.add(response.path("pages[0].hideableType"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[0].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[0].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[0].type"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[1].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[1].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[1].type"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].type"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].style.code"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].style.backGroundColor"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].style.fontColor"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].type"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].style.code"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].style.backGroundColor"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].style.fontColor"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[4].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[4].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[4].type"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].type"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].link.linkAddress"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].link.linkType"));

            flightStepFiveSliderNone.add(response.path("name"));
            flightStepFiveSliderNone.add(response.path("theme"));
            flightStepFiveSliderNone.add(response.path("offerType"));
        }
    }
}
