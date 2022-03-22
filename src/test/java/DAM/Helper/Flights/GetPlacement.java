package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class GetPlacement {
    String[] placement;

    public GetPlacement() throws JSONException {
        placement = new String[8];

        String id = new CreateFlightStepTwo().getFlightStepTwo()[8];

        Response response = given().when().get(id + "/placement/").then().extract().response();

        placement[0] = response.path("name");
        placement[1] = response.path("code");
        placement[2] = response.path("locations[0].name");
        placement[3] = response.path("locations[0].code");
        placement[4] = response.path("locations[0].positions[0].name");
        placement[5] = response.path("locations[0].positions[0].code");
        placement[6] = response.path("locations[0].positions[0].formats[0].name");
        placement[7] = response.path("locations[0].positions[0].formats[0].code");
    }

    public String[] getPlacement() {
        return placement;
    }
}
