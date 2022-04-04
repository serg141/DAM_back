package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class FlightPlacement {
    private ArrayList<String> flightPlacement = new ArrayList<>();

    public FlightPlacement() throws JSONException {
        String id = new CreateFlightStepTwo().getFlightStepTwo().get(8);

        Response response = given().when().get(id + "/placement/").then().extract().response();

        flightPlacement.add(response.path("name"));
        flightPlacement.add(response.path("code"));
        flightPlacement.add(response.path("locations[0].name"));
        flightPlacement.add(response.path("locations[0].code"));
        flightPlacement.add(response.path("locations[0].positions[0].name"));
        flightPlacement.add(response.path("locations[0].positions[0].code"));
        flightPlacement.add(response.path("locations[0].positions[0].formats[0].name"));
        flightPlacement.add(response.path("locations[0].positions[0].formats[0].code"));
    }
}
