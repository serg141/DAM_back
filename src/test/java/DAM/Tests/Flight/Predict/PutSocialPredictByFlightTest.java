package DAM.Tests.Flight.Predict;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Flights.PutFlightStepThreePredict;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PutSocialPredictByFlightTest {
    String logIn, flights, id, segmentSocial, predict, body;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        //id = new CreateFlightWithAuthParameters().getId();
        body = new PutFlightStepThreePredict().getFlight();

        flights = new EndPoints().getFlights();
        segmentSocial = new EndPoints().getSegmentSocial();
        predict = new EndPoints().getPredict();
    }

    @Test
    public void putPredictSocial() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(flights + id + segmentSocial + predict)
                .then()
                .extract().response();

        Integer i = 10000000;
        assertEquals(i, response.path("data"));
    }
}
