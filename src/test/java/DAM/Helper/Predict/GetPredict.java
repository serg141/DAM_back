package DAM.Helper.Predict;

import DAM.Helper.Flights.CreateFlightWithTechParameters;
import DAM.Parametrs.Flights.PutFlightStepFourPredict;
import DAM.Parametrs.Flights.PutFlightStepThreePredict;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class GetPredict {
    int[] predict;

    public GetPredict() throws JSONException {
        predict = new int[3];
        String id = new CreateFlightWithTechParameters().getFlightStepFour().get(6);
        String body1 = new PutFlightStepThreePredict().getFlight();
        String body2 = new PutFlightStepFourPredict().getFlight();

        Response response = given().when().get(id + "/predict/").then().extract().response();
        predict[0] = response.path("data");

        response = given().body(body1).when().put(id + "/segments/social/predict").then().extract().response();
        predict[1] = response.path("data");

        response = given().body(body2).when().put(id + "/segments/tech/predict").then().extract().response();
        predict[2] = response.path("data");
    }

    public int[] getPredict() {
        return predict;
    }
}
