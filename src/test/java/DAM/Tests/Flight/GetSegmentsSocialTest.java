package DAM.Tests.Flight;

import DAM.EndPoints;
import DAM.Flights.CreateFlightWithAuthParameters;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepThreeSocialParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetSegmentsSocialTest {
    String logIn, flights, id, segmentSocial, body;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightWithAuthParameters().getId();
        body = new CreateFlightStepThreeSocialParams().getFlight();

        flights = new EndPoints().getFlights();
        segmentSocial = new EndPoints().getSegmentSocial();
    }

    @Test
    public void successCreate() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + segmentSocial)
                .then().statusCode(200)
                .extract().response();

        List<String> specialParams = response.path("specialParams");
        LinkedHashMap<String,Object> selections = response.path("selections[0]");

        assertTrue(specialParams.contains("ageAll"));
        assertTrue(specialParams.contains("genderAll"));
        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", selections.get("categoryUuid"));
        assertEquals(true, response.path("segmentIdsMap.26a42f93-7499-4c4a-9fee-0cfba8309d15"));
    }
}
