package DAM.Tests.Flight.Predict;

import DAM.EndPoints;
import DAM.Flights.CreateFlightWithTechParameters;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetPredictByFlightTest {
    String logIn, flights, id, predict;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightWithTechParameters().getId();

        flights = new EndPoints().getFlights();
        predict = new EndPoints().getPredict();
    }

    @Test
    public void getPredict() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + predict)
                .then()
                .extract().response();

        Integer i = 1;
        assertEquals(i, response.path("data"));
    }
}
