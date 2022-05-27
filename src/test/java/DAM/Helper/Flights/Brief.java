package DAM.Helper.Flights;

import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Brief {

    public ArrayList<String> DownloadBrief() {
        ArrayList<String> brief = new ArrayList<>();

        Response response = given().spec(Specification.brief())
                .multiPart("file", new File("D:\\MS\\Test_Brief.docx"))
                .post().then().extract().response();

        brief.add(response.path("originalName"));
        brief.add(response.path("briefId"));

        return brief;
    }

    public String GetBrief() throws JSONException {
        String id = new CreateFlights().CreateStepOne().get(5);
        String brief;

        given().when().get(id + "/brief/file");
        Response response = given().when().get(id + "/brief");
        brief = response.path("originalName");

        return brief;
    }
}
