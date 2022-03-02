package DAM.Flights;

import DAM.LogIn;
import DAM.Parametrs.CreateFlightStepOneParams;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateFlightStepTwo {
    String id;
    public CreateFlightStepTwo() throws JSONException {
        String logIn = new LogIn().logIn();
        String body = new CreateFlightStepOneParams().getFlight();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post("/flights")
                .then().extract().response();

        id = response.path("id").toString();
    }

    public String getId() {
        return id;
    }
}
