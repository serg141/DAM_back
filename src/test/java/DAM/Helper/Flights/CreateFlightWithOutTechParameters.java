package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFourTechParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightWithOutTechParameters {
    ArrayList<String> flightStepFour = new ArrayList<>();

    public CreateFlightWithOutTechParameters() throws JSONException {
        String id = new CreateFlightWithAuthParameters().getFlightStepThree().get(3);
        String body = new CreateFlightStepFourTechParams().getFlightWithOutParameters();

        Response response = given().body(body).when().post(id + "/segments/tech").then().extract().response();

        flightStepFour.add(response.path("selections[0].categoryUuid"));
        flightStepFour.add(response.path("selections[0].filters").toString());
        flightStepFour.add(response.path("selections[1].categoryUuid"));
        flightStepFour.add(response.path("selections[1].filters").toString());
        flightStepFour.add(response.path("segmentIdsMap").toString());
        flightStepFour.add(id);
    }
}
