package ClientInfo.Helper;

import ClientInfo.Specification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class DAMSeg1Seg2FlgTrue {
    private ArrayList<String> segments = new ArrayList<>();

    public DAMSeg1Seg2FlgTrue() {
        RestAssured.useRelaxedHTTPSValidation();
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().when().get("1234567891").then().extract().response();
        segments.add(response.path("segmentsList").toString());
    }
}
