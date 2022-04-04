package DAM.Tests.Flight.Brief;

import DAM.Helper.Flights.CreateFlightStepOne;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetBriefTest {

    @Test
    public void getBriefTest() throws JSONException {
        String id = new CreateFlightStepOne().getFlightStepOne().get(5);

        given().when().get(id + "/brief/file");
        Response response = given().when().get(id + "/brief");

        assertEquals("Test_Brief.docx", response.path("originalName"));
    }
}
