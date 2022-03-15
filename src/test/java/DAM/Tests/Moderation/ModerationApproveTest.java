package DAM.Tests.Moderation;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Moderation.SendToModeration;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ModerationApproveTest {
    String logIn, moderationStart, moderationApprove, id, flights;

    @Before
    public void getEndpoint() throws JSONException, InterruptedException {
        logIn = new LogIn().logIn();
        id = new SendToModeration().getId();

        flights = new EndPoints().getFlights();
        moderationStart = new EndPoints().getModerationStart();
        moderationApprove = new EndPoints().getModerationApprove();

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .put(flights + id + moderationStart);
    }

    @Test
    public void moderationApprove() {
        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .put(flights + id + moderationApprove);
    }
}
