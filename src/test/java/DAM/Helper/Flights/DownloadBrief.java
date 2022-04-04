package DAM.Helper.Flights;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import java.io.File;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class DownloadBrief {
    private ArrayList<String> briefName = new ArrayList<>();

    public DownloadBrief() {
        Specification.installSpec(Specification.brief(), Specification.responseSpec200());

        Response response = given()
                .multiPart("file", new File("D:\\MS\\Test_Brief.docx"))
                .post().then().extract().response();

        briefName.add(response.path("originalName"));
        briefName.add(response.path("briefId"));
    }
}
