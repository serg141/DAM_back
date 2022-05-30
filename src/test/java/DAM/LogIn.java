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

        user.put("login","vtb4040204@corp.dev.vtb");
        user.put("pass", "admin");

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().body(user.toString()).when().post("/login");
        sessionId = response.getCookie("JSESSIONID");
        given().cookie("JSESSIONID", sessionId).when().get("/me");
    }
}
