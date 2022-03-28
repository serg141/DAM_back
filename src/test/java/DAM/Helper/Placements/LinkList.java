package DAM.Helper.Placements;

import DAM.Parametrs.Placements.Lists.CreateLinkList;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class LinkList {
    String[] linkList;

    public LinkList() throws JSONException {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());

        String body = new CreateLinkList().getLinkList();
        linkList = new String[9];

        Response response = given().body(body).when().post().then().extract().response();
        if(response.path("elements[0].required")) {
            if(response.path("elements[1].required")) {
                linkList[0] = response.path("name");
                linkList[1] = response.path("code");
                linkList[2] = response.path("elements[0].name");
                linkList[3] = response.path("elements[0].elementId");
                linkList[4] = response.path("elements[0].type");
                linkList[5] = response.path("elements[0].backgroundType");
                linkList[6] = response.path("elements[1].name");
                linkList[7] = response.path("elements[1].elementId");
                linkList[8] = response.path("elements[1].type");
            }
        }

        String id = response.path("id");

        given().when().delete(id);
    }
}
