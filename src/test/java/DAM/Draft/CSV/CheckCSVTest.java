package DAM.Draft.CSV;

import DAM.EndPoints;
import DAM.Flights.CreateFlightStepTwo;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CheckCSVTest {
    String logIn, flights, id, checkCSV;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightStepTwo().getId();

        flights = new EndPoints().getFlights();
        checkCSV = new EndPoints().getCheckCSV();

    }

    @Test
    public void successCreate() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .contentType("multipart/form-data")
                .multiPart("file", new File("C:\\Users\\SKamynin\\Desktop\\csv\\client-info\\mdm_id_10.csv"),
                        "vnd.ms-excel")
                .when()
                .post(flights + checkCSV)
                .then().statusCode(200)
                .extract().response();

        Integer i = 9999;
        assertEquals(i, response.path("data"));
    }
}
