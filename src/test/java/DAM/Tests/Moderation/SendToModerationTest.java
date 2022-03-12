package DAM.Tests.Moderation;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Moderation.SendToModeration;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class SendToModerationTest {
    String logIn, body, moderation, flights;
    String[] idList;
    Response response;

    @Before
    public void getEndpoint() throws JSONException {
        idList = new SendToModeration().getIdList();
        logIn = new LogIn().logIn();
        body = idList[0];

        flights = new EndPoints().getFlights();
        moderation = new EndPoints().getModeration();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(flights + moderation);

        response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + idList[1]);
    }

    @Test
    public void SendToModeration() {
        assertEquals("MODERATION_CLAIMED", response.path("status"));
    }
}
