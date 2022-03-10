package Example;

import DAM.EndPoints;
import DAM.Parametrs.Teams.CreateTeam;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateTeams {
    static String logIn;
    static String teams;
    static String body;

    public static void main(String[] args) throws JSONException {
        logIn = new LogIn().logIn();
        body = new CreateTeam().getTeam();

        teams = new EndPoints().getTeams();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(teams)
                .then().statusCode(200);
    }
}
