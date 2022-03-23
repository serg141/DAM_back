package DAM.Helper.Placements;

import DAM.Parametrs.Placements.Lists.CreateNumberList;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class NumberedList {
    String[] numberList;

    public NumberedList() throws JSONException {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());

        String body = new CreateNumberList().getNumberedList();
        numberList = new String[10];

        Response response = given().body(body).when().post().then().extract().response();
        if(response.path("elements[0].required")) {
            if(response.path("elements[1].required").equals(false)) {
                numberList[0] = response.path("name");
                numberList[1] = response.path("code");
                numberList[2] = response.path("elements[0].name");
                numberList[3] = response.path("elements[0].elementId");
                numberList[4] = response.path("elements[0].type");
                numberList[5] = response.path("elements[0].elementStyle");
                numberList[6] = response.path("elements[1].name");
                numberList[7] = response.path("elements[1].elementId");
                numberList[8] = response.path("elements[1].type");
                numberList[9] = response.path("elements[1].elementStyle");
            } else System.out.println("required1 = true");
        } else System.out.println("required2 = false");

        String id = response.path("id");

        given().when().delete(id);
    }
}
