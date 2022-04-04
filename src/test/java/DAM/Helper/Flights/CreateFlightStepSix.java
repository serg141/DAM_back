package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepSix {
    private ArrayList<String> flightStepSix = new ArrayList<>();

    public CreateFlightStepSix() throws JSONException {
        String id = new CreateFlightStepFivePrerollNone().getFlightStepFivePrerollNone().get(21);
        Response response = given().when().get(id + "/summary").then().extract().response();

        if(response.path("socialSegmentsInfo.auditorial.extendedDescription[0].children[0].include")) {
            if(response.path("techSegmentsInfo.arInfo")) {
                flightStepSix.add(response.path("basicInfo.name"));
                flightStepSix.add(response.path("basicInfo.frequency.term"));
                flightStepSix.add(response.path("placementInfo.channelName"));
                flightStepSix.add(response.path("placementInfo.places[0].locationName"));
                flightStepSix.add(response.path("placementInfo.places[0].positionName"));
                flightStepSix.add(response.path("placementInfo.places[0].formatName"));
                flightStepSix.add(response.path("socialSegmentsInfo.auditorial.shortDescription"));
                flightStepSix.add(response.path("socialSegmentsInfo.auditorial.extendedDescription[0].name"));
                flightStepSix.add(response.path("socialSegmentsInfo.auditorial.extendedDescription[0].children[0].name"));
                flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].os"));
                flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].versionsInclude.fromAppVer"));
                flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].versionsInclude.toAppVer"));
                flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].versionsExclude"));
                flightStepSix.add(id);
            }
        }
    }
}
