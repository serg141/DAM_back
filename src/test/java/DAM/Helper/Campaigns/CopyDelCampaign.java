package DAM.Helper.Campaigns;

import DAM.PojoClasses.NewCampaign;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

@Data
public class CopyDelCampaign {
    private ArrayList<String> dataCamp = new ArrayList<>();

    public CopyDelCampaign() {
        Specification.installSpec(Specification.requestSpecCampaigns(), Specification.responseSpec200());

        Response response = given().when().post("all").then().extract().response();

        String id = response.path("content[0].id");

        given().when().put(id + "/duplicate/");

        List<NewCampaign> data = given()
                .queryParam("pageSize", 100)
                .queryParam("sortBy", "modifiedTime")
                .queryParam("sortDirection", "DESC")
                .when()
                .post("all")
                .then()
                .extract().body().jsonPath().getList("content", NewCampaign.class);

        List<String> names = data.stream().map(NewCampaign::getName).collect(Collectors.toList());
        List<String> statuses = data.stream().map(NewCampaign::getStatus).collect(Collectors.toList());
        List<String> ids = data.stream().map(NewCampaign::getId).collect(Collectors.toList());

        dataCamp.add(names.get(0));
        dataCamp.add(statuses.get(0));
    }
}
