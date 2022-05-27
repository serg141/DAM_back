package DAM;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

@Data
public class LogIn {
    JSONObject user = new JSONObject();
    String sessionId;

    public LogIn() throws JSONException {

        user.put("login","vtb4040204");
        user.put("pass", "141523Pota!!");

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().body(user.toString()).when().post("/login");
        sessionId = response.getCookie("JSESSIONID");
        given().cookie("JSESSIONID", sessionId).when().get("/me");

        //given().cookie("JSESSIONID", response.getCookie("JSESSIONID")).when().get("/me");
        //return response.getSessionId();
    }
}
