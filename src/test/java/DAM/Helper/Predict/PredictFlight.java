package DAM.Helper.Predict;

import DAM.Helper.Flights.CreateFlightWithTechParameters;
import DAM.Parametrs.Flights.PutFlightStepFourPredict;
import DAM.Parametrs.Flights.PutFlightStepThreePredict;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class PredictFlight {
    ArrayList<Integer> predict = new ArrayList<>();

    public PredictFlight() throws JSONException {
        String id = new CreateFlightWithTechParameters().getFlightStepFour().get(6);
        String body1 = new PutFlightStepThreePredict().getFlight();
        String body2 = new PutFlightStepFourPredict().getFlight();

        Response response = given().when().get(id + "/predict/").then().extract().response();
        predict.add(response.path("data"));

        response = given().body(body1).when().put(id + "/segments/social/predict").then().extract().response();
        predict.add(response.path("data"));

        response = given().body(body2).when().put(id + "/segments/tech/predict").then().extract().response();
        predict.add(response.path("data"));
    }
}
