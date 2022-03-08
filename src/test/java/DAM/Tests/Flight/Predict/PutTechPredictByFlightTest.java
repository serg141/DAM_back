package DAM.Tests.Flight.Predict;

import DAM.EndPoints;
import DAM.Flights.CreateFlightWithTechParameters;
import DAM.LogIn;
import DAM.Parametrs.Flights.PutFlightStepFourPredict;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PutTechPredictByFlightTest {
    String logIn, flights, id, segmentsTech, predict, body;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightWithTechParameters().getId();
        body = new PutFlightStepFourPredict().getFlight();

        flights = new EndPoints().getFlights();
        segmentsTech = new EndPoints().getSegmentsTech();
        predict = new EndPoints().getPredict();
    }

    @Test
    public void putPredictTech() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(flights + id + segmentsTech + predict)
                .then().statusCode(200)
                .extract().response();

        Integer i = 0;
        assertEquals(i, response.path("data"));
    }
}
