package DAM.Moderation;

import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class SendToModeration {
    String logIn, body, moderation, flights, id;
    String[] idList;

    public SendToModeration() throws JSONException {
        idList = new DAM.Parametrs.Moderation.SendToModeration().getIdList();
        logIn = new LogIn().logIn();
        body = idList[0];

        flights = new EndPoints().getFlights();
        moderation = new EndPoints().getModeration();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(flights + moderation);

        id = idList[1];
    }

    public String getId() {
        return id;
    }
}
