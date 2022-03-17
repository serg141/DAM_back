package DAM.Flights;

import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightStepSix {
    String[] flightStepSix;

    public CreateFlightStepSix() throws JSONException {
        flightStepSix = new String[13];
        String id = new CreateFlightStepFivePrerollNone().getFlightStepFivePrerollNone()[21];
        Response response = given().when().get(id + "/summary").then().extract().response();

        if(response.path("socialSegmentsInfo.auditorial.extendedDescription[0].children[0].include")) {
            if(response.path("techSegmentsInfo.arInfo")) {
                flightStepSix[0] = response.path("basicInfo.name");
                flightStepSix[1] = response.path("basicInfo.frequency.term");
                flightStepSix[2] = response.path("placementInfo.channelName");
                flightStepSix[3] = response.path("placementInfo.places[0].locationName");
                flightStepSix[4] = response.path("placementInfo.places[0].positionName");
                flightStepSix[5] = response.path("placementInfo.places[0].formatName");
                flightStepSix[6] = response.path("socialSegmentsInfo.auditorial.shortDescription");
                flightStepSix[7] = response.path("socialSegmentsInfo.auditorial.extendedDescription[0].name");
                flightStepSix[8] = response.path("socialSegmentsInfo.auditorial.extendedDescription[0].children[0].name");
                flightStepSix[9] = response.path("techSegmentsInfo.appInfo[0].os");
                flightStepSix[10] = response.path("techSegmentsInfo.appInfo[0].versionsInclude.fromAppVer");
                flightStepSix[11] = response.path("techSegmentsInfo.appInfo[0].versionsInclude.toAppVer");
                flightStepSix[12] = response.path("techSegmentsInfo.appInfo[0].versionsExclude");
            }
        }
    }

    public String[] getFlightStepSix() {
        return flightStepSix;
    }
}
