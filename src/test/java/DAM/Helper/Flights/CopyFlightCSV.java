package DAM.Helper.Flights;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.io.File;

import static io.restassured.RestAssured.given;

@Data
public class CopyFlightCSV {
    String status;

    public CopyFlightCSV() throws JSONException {
        String id = new CreateFlightStepTwo().getFlightStepTwo().get(8);

        int a = (int) (Math.random()*1000);

        given().contentType(ContentType.MULTIPART)
                .multiPart("file",
                        new File("C:\\Users\\skamy\\Desktop\\csv\\client-info\\mdm_id_10.csv"),
                        "text/csv")
                .multiPart("segmentName", "test" + a).when().post(id + "/csv-segment");

        Response response = given().when().put(id + "/duplicate").then().extract().response();

        status = response.path("data");
    }
}
