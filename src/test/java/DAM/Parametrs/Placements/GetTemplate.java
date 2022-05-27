package DAM.Parametrs.Placements;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetTemplate {
    String templateGhost, templateSlider, templatePreRoll;

    public GetTemplate() throws JSONException {
        String logIn = new LogIn().getSessionId();

        String template = new EndPoints().getTemplate();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(template)
                .then()
                .extract().response();

        ArrayList<String> code = response.path("code");
        ArrayList<String> id = response.path("id");

        for(int i = 0; i < id.size(); i++) {
            if (code.get(i).equals("SLIDER")) templateSlider = id.get(i);
            if (code.get(i).equals("GHOST_BANNER1")) templateGhost = id.get(i);
            if (code.get(i).equals("PREROLL_TEMPLATE")) templatePreRoll = id.get(i);
        }
    }

    public String getTemplateGhost() {
        return templateGhost;
    }

    public String getTemplateSlider() {
        return templateSlider;
    }

    public String getTemplatePreRoll() {
        return templatePreRoll;
    }
}
