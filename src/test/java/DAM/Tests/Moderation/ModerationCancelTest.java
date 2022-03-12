package DAM.Tests.Moderation;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Moderation.SendToModeration;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ModerationCancelTest {
    String logIn, moderationStart, moderationCancel, id, flights;
    Response response;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new SendToModeration().getId();

        flights = new EndPoints().getFlights();
        moderationStart = new EndPoints().getModerationStart();
        moderationCancel = new EndPoints().getModerationCancel();

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .put(flights + id + moderationStart);

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .put(flights + id + moderationCancel);

        response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id);
    }

    @Test
    public void moderationCancel() {
        assertEquals("MODERATION_CLAIMED", response.path("status"));
    }
}
