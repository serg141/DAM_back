package ClientInfo.Helper;

import ClientInfo.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class DAMSeg1FlgTrue {
    private ArrayList<String> segments = new ArrayList<>();

    public DAMSeg1FlgTrue() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().when().get("1234567897").then().extract().response();
        segments.add(response.path("id"));
        segments.add(response.path("segments.BIRTH_DAY"));
        segments.add(response.path("segments.BIRTH_MONTH"));
        segments.add(response.path("segments.BIRTH_YEAR"));
        segments.add(response.path("segmentsList.SPEND[0]"));
        segments.add(response.path("variables.\"SCP.Trnsf90DAmt\""));
        segments.add(response.path("variables.\"SCP.LstPrftKplk90DAmt\""));
    }
}
