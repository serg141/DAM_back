package DAM.Helper.Flights;

import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetSegments {

    public ArrayList<String> GetSegmentsSocial() throws JSONException {
        ArrayList<String> segments = new ArrayList<>();
        String id = new CreateFlights().CreateStepThreeWithAuth().get(3);

        Response response = given().when().get(id + "/segments/social").then().extract().response();

        if(response.path("segmentIdsMap.26a42f93-7499-4c4a-9fee-0cfba8309d15")) {
            segments.add(response.path("selections[0].categoryUuid"));
            segments.add(response.path("specialParams[0]"));
            segments.add(response.path("specialParams[1]"));
        }

        return segments;
    }

    public ArrayList<String> GetSegmentsTech() throws JSONException {
        String id = new CreateFlights().CreateStepFourWithTech().get(6);
        ArrayList<String> segments = new ArrayList<>();

        Response response = given().when().get(id + "/segments/tech").then().extract().response();

        if(response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b")) {
            if(response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"))
            {
                if(response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a")) {
                    segments.add(response.path("selections[1].categoryUuid"));
                    segments.add(response.path("selections[1].filters.fromAppVer"));
                    segments.add(response.path("selections[1].filters.toAppVer"));
                    segments.add(response.path("selections[0].categoryUuid"));
                }
            }
        }

        return segments;
    }

    public ArrayList<String> GetSegmentCategories() {
        ArrayList<String> categories = new ArrayList<>();

        Response response = given().spec(Specification.requestSegmentCategories())
                .when().get().then().extract().response();

        categories.add(response.path("AUDITORIAL[0].code"));
        categories.add(response.path("CLIENTTYPE[0].code"));
        categories.add(response.path("BLACKLIST[0].code"));
        categories.add(response.path("AGE[0].code"));
        categories.add(response.path("GENDER[0].code"));

        return categories;
    }
}
