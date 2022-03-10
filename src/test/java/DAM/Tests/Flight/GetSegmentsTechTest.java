package DAM.Tests.Flight;

import DAM.EndPoints;
import DAM.Flights.CreateFlightWithTechParameters;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepFourTechParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetSegmentsTechTest {
    String logIn, flights, id, segmentsTech, body;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightWithTechParameters().getId();
        body = new CreateFlightStepFourTechParams().getFlightWithParameters();

        flights = new EndPoints().getFlights();
        segmentsTech = new EndPoints().getSegmentTech();
    }

    @Test
    public void successCreate() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + segmentsTech)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> selections0 = response.path("selections[0]");
        LinkedHashMap<String,Object> selections1 = response.path("selections[1]");
        LinkedHashMap<String,Object> selections2 = response.path("selections[2]");
        LinkedHashMap<String,Object> version = new LinkedHashMap<>();

        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", selections0.get("categoryUuid"));
        assertEquals(version, selections0.get("filters"));
        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", selections1.get("categoryUuid"));
        assertEquals("15.4.0", response.path("selections[1].filters.fromAppVer"));
        assertEquals("15.4.2", response.path("selections[1].filters.toAppVer"));
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", selections2.get("categoryUuid"));
        assertEquals("15.4.0", response.path("selections[2].filters.fromAppVer"));
        assertEquals("15.4.2", response.path("selections[2].filters.toAppVer"));
        assertEquals(true, response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b"));
        assertEquals(true, response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"));
        assertEquals(true, response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a"));
        assertEquals(false, response.path("segmentIdsMap.66f04a9c-1e63-4583-8137-bfa016f4f7d6"));
        assertEquals(false, response.path("segmentIdsMap.9cab5e85-b6bd-4fe3-a4ab-2df010c554c3"));
    }
}
