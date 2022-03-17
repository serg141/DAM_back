package DAM.Parametrs.Filters;

import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreatorParams {
    private String creatorIds;
    JSONObject body = new JSONObject();

    public CreatorParams() throws JSONException {
        String logIn = new LogIn().logIn();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .queryParam("pageSize", 25)
                .when()
                .get("/users/list")
                .then()
                .extract().response();

        ArrayList<String> userName = response.path("fullName");
        ArrayList<String> id = response.path("id");
        for(int i = 0; i < userName.size(); i++) {
            if(userName.get(i).contains("Камынин Сергей Игоревич")) creatorIds = id.get(i);
        }

        JSONArray creator = new JSONArray();
        creator.put(creatorIds);
        body.put("creatorIds", creator);

        int i = 0;
    }

    public String getBody() {
        return body.toString();
    }
}
