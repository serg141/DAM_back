package DAM.Helper.Flights;

import DAM.Parametrs.Flights.PutFlightStepFourPredict;
import DAM.Parametrs.Flights.PutFlightStepThreePredict;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class PredictFlight {

    public ArrayList<Integer> PredictFlightStepThreeAuth() throws JSONException {
        ArrayList<Integer> predict = new ArrayList<>();
        String id = new CreateFlights().CreateStepThreeWithAuth().get(3);
        String body = new PutFlightStepThreePredict().getFlight().toString();

        Response response = given().when().get(id + "/predict/").then().extract().response();
        predict.add(response.path("data"));

        response = given().body(body).when().put(id + "/segments/social/predict").then().extract().response();
        predict.add(response.path("data"));

        return predict;
    }

    public ArrayList<Integer> PredictFlightStepFourTech() throws JSONException {
        ArrayList<Integer> predict = new ArrayList<>();

        String id = new CreateFlights().CreateStepFourWithTech().get(6);
        String body = new PutFlightStepFourPredict().getFlight().toString();

        Response response = given().when().get(id + "/predict/").then().extract().response();
        predict.add(response.path("data"));

        response = given().body(body).when().put(id + "/segments/tech/predict").then().extract().response();
        predict.add(response.path("data"));

        return predict;
    }
}
