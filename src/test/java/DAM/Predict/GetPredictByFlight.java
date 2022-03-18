package DAM.Predict;

import DAM.Flights.CreateFlightWithTechParameters;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class GetPredictByFlight {
    int predict;

    public GetPredictByFlight() throws JSONException {
        String id = new CreateFlightWithTechParameters().getFlightStepFour()[6];

        Response response = given()
                .when()
                .get(id + "/predict/")
                .then()
                .extract().response();

        predict = response.path("data");
    }

    public int getPredict() {
        return predict;
    }
}
