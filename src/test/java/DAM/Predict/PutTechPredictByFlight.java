package DAM.Predict;

import DAM.Flights.CreateFlightWithTechParameters;
import DAM.Parametrs.Flights.PutFlightStepFourPredict;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class PutTechPredictByFlight {
    int predict;

    public PutTechPredictByFlight() throws JSONException {
        String id = new CreateFlightWithTechParameters().getFlightStepFour()[6];
        String body = new PutFlightStepFourPredict().getFlight();

        Response response = given()
                .body(body)
                .when()
                .put(id + "/segments/tech/predict")
                .then()
                .extract().response();

        predict = response.path("data");
    }
}
