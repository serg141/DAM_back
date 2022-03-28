package DAM.Helper.Flights;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import java.io.File;
import static io.restassured.RestAssured.given;

@Data
public class DownloadBrief {
    String[] briefName;

    public DownloadBrief() {
        Specification.installSpec(Specification.brief(), Specification.responseSpec200());
        briefName = new String[2];

        Response response = given()
                .multiPart("file", new File("D:\\MS\\Test_Brief.docx"))
                .post().then().extract().response();

        briefName[0] = response.path("originalName");
        briefName[1] = response.path("briefId");
    }
}
