package DAM.Draft.CSV;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DownloadCSVTest {
    String logIn, flights, id, segmentCSV;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().getUser().toString();
        //id = new CreateFlightStepTwo().getId();

        flights = new EndPoints().getFlights();
        segmentCSV = new EndPoints().getCsvSegment();

    }

    @Test
    public void successCreate() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .contentType("multipart/form-data")
                .multiPart("file", new File("C:\\Users\\SKamynin\\Desktop\\csv\\client-info\\mdm_id_10.csv"),
                        "vnd.ms-excel")
                .multiPart("segmentName", "TEST12")
                .when()
                .post(flights + id + segmentCSV)
                .then().statusCode(200)
                .extract().response();

        assertEquals("TEST12", response.path("name"));
        assertEquals("mdm_id_10.csv", response.path("fileName"));
        assertEquals("NOT_READY", response.path("status"));
        assertEquals("Ожидает обработки.", response.path("statusDescription"));

        given()
                .cookie("JSESSIONID", logIn)
                .contentType("multipart/form-data")
                .when()
                .get(flights + id + "/csv/file")
                .then().statusCode(200);
    }
}
