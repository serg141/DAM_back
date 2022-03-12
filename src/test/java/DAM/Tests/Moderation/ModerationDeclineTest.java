package DAM.Tests.Moderation;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Moderation.SendToModeration;
import DAM.Parametrs.Moderation.ModerationDecline;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ModerationDeclineTest {
    String logIn, moderationStart, moderationDecline, id, flights, body;
    Response response;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new SendToModeration().getId();
        body = new ModerationDecline().getComments();

        flights = new EndPoints().getFlights();
        moderationStart = new EndPoints().getModerationStart();
        moderationDecline = new EndPoints().getModerationDecline();

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .put(flights + id + moderationStart);

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(flights + id + moderationDecline);

        response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id);
    }

    @Test
    public void moderationDecline() {
        assertEquals("DECLINED", response.path("status"));
    }
}
