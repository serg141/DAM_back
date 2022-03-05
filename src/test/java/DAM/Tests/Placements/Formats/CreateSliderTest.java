package DAM.Tests.Placements.Formats;

import DAM.LogIn;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateSliderTest {
    String logIn;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
    }

    @Test
    public void successCreate() {
        given()
                .cookie("JSESSIONID", logIn)
                .contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\SKamynin\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("template", new File("C:\\Users\\SKamynin\\Desktop\\yaml\\json\\template\\Slider_JSON.json"),
                        "application/json")
                .when()
                .post("/templates");
    }
}
