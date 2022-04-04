package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepThreeSocialParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightWithAuthParameters {
    ArrayList<String> flightStepThree = new ArrayList<>();

    public CreateFlightWithAuthParameters() throws JSONException {
        String body = new CreateFlightStepThreeSocialParams().getFlight();
        String id = new CreateFlightStepTwo().getFlightStepTwo().get(8);

        Response response = given().body(body).when().post(id + "/segments/social").then().extract().response();

        if (response.path("segmentIdsMap.26a42f93-7499-4c4a-9fee-0cfba8309d15")) {
            List<String> specialParams = response.path("specialParams");
            flightStepThree.add(response.path("selections[0].categoryUuid"));
            flightStepThree.add(specialParams.get(0));
            flightStepThree.add(specialParams.get(1));
            flightStepThree.add(id);
        }
    }
}
