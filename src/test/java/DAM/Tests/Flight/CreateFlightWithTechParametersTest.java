package DAM.Tests.Flight;

import DAM.EndPoints;
import DAM.Flights.CreateFlightWithAuthParameters;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepFourTechParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightWithTechParametersTest {
    String logIn, flights, id, segmentTech, body1, body2;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightWithAuthParameters().getId();
        body1 = new CreateFlightStepFourTechParams().getFlightWithOutParameters();
        body2 = new CreateFlightStepFourTechParams().getFlightWithParameters();

        flights = new EndPoints().getFlights();
        segmentTech = new EndPoints().getSegmentsTech();
    }

    @Test
    public void successCreateWithOutVersion() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body1)
                .when()
                .post(flights + id + segmentTech)
                .then().statusCode(200)
                .extract().response();

        LinkedHashMap<String,Object> selections0 = response.path("selections[0]");
        LinkedHashMap<String,Object> selections1 = response.path("selections[1]");
        LinkedHashMap<String,Object> version = new LinkedHashMap<>();

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", selections0.get("categoryUuid"));
        assertEquals(version, selections0.get("filters"));
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", selections1.get("categoryUuid"));
        assertEquals(version, selections1.get("filters"));
        assertEquals(version, response.path("segmentIdsMap"));
    }

    @Test
    public void successCreateWithVersions() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body2)
                .when()
                .post(flights + id + segmentTech)
                .then().statusCode(200)
                .extract().response();

        LinkedHashMap<String,Object> selections0 = response.path("selections[0]");
        LinkedHashMap<String,Object> selections1 = response.path("selections[1]");

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", selections0.get("categoryUuid"));
        assertEquals("15.4.0", response.path("selections[0].filters.fromAppVer"));
        assertEquals("15.4.2", response.path("selections[0].filters.toAppVer"));
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", selections1.get("categoryUuid"));
        assertEquals("15.4.0", response.path("selections[1].filters.fromAppVer"));
        assertEquals("15.4.2", response.path("selections[1].filters.toAppVer"));
        assertEquals(true, response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b"));
        assertEquals(true, response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"));
        assertEquals(true, response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a"));
        assertEquals(false, response.path("segmentIdsMap.66f04a9c-1e63-4583-8137-bfa016f4f7d6"));
        assertEquals(false, response.path("segmentIdsMap.9cab5e85-b6bd-4fe3-a4ab-2df010c554c3"));
    }
}
