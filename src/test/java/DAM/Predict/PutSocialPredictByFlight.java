package DAM.Predict;

import DAM.Flights.CreateFlightWithAuthParameters;
import DAM.Parametrs.Flights.PutFlightStepThreePredict;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class PutSocialPredictByFlight {
    int predict;

    public PutSocialPredictByFlight() throws JSONException {
        String body = new PutFlightStepThreePredict().getFlight();
        String id = new CreateFlightWithAuthParameters().getFlightStepThree()[3];

        Response response = given()
                .body(body)
                .when()
                .put(id + "/segments/social/predict")
                .then()
                .extract().response();

        predict = response.path("data");
    }
}
