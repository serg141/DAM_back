package DAM.Helper.Flights;

import DAM.Parametrs.Flights.*;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateFlights {

    public ArrayList<String> CreateStepOne() throws JSONException {
        ArrayList<String> flightStepOne = new ArrayList<>();
        String body = new CreateFlightStepOneParams().getFlight().toString();

        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());
        Response response = given().body(body).when().post().then().extract().response();

        flightStepOne.add(response.path("name"));
        flightStepOne.add(response.path("status"));
        flightStepOne.add(response.path("purpose"));
        flightStepOne.add(response.path("frequency.term"));
        flightStepOne.add(response.path("createdBy"));
        flightStepOne.add(response.path("id"));

        return flightStepOne;
    }

    public ArrayList<String> CreateStepTwo() throws JSONException {
        ArrayList<String> flightStepTwo = new ArrayList<>();
        String id = new CreateFlights().CreateStepOne().get(5);
        String body = new CreateFlightStepTwoParams().getFlight().toString();

        Response response = given().body(body).when().post(id + "/placement/").then().extract().response();

        flightStepTwo.add(response.path("name"));
        flightStepTwo.add(response.path("code"));
        flightStepTwo.add(response.path("locations[0].name"));
        flightStepTwo.add(response.path("locations[0].code"));
        flightStepTwo.add(response.path("locations[0].positions[0].name"));
        flightStepTwo.add(response.path("locations[0].positions[0].code"));
        flightStepTwo.add(response.path("locations[0].positions[0].formats[0].name"));
        flightStepTwo.add(response.path("locations[0].positions[0].formats[0].code"));
        flightStepTwo.add(id);

        return flightStepTwo;
    }

    public ArrayList<String> CreateStepThreeWithCsv() throws JSONException {
        ArrayList<String> flightStepThreeWithCsv = new ArrayList<>();
        String id = new CreateFlights().CreateStepTwo().get(8);
        int a = (int) (Math.random()*1000);

        Response response = given().spec(Specification.requestSpecCsv())
                .multiPart("file",
                        new File("C:\\Users\\skamy\\Desktop\\csv\\client-info\\mdm_id_10.csv"),
                        "text/csv")
                .multiPart("segmentName", "test" + a)
                .when().post(id + "/csv-segment");

        flightStepThreeWithCsv.add(response.path("fileName"));
        flightStepThreeWithCsv.add(response.path("status"));
        flightStepThreeWithCsv.add(response.path("statusDescription"));
        flightStepThreeWithCsv.add(id);

        return flightStepThreeWithCsv;
    }

    public ArrayList<String> CreateStepThreeWithAuth() throws JSONException {
        ArrayList<String> flightStepThreeWithAuth = new ArrayList<>();
        String body = new CreateFlightStepThreeSocialParams().getFlight().toString();
        String id = new CreateFlights().CreateStepTwo().get(8);

        Response response = given().body(body).when().post(id + "/segments/social").then().extract().response();

        if (response.path("segmentIdsMap.26a42f93-7499-4c4a-9fee-0cfba8309d15")) {
            List<String> specialParams = response.path("specialParams");
            flightStepThreeWithAuth.add(response.path("selections[0].categoryUuid"));
            flightStepThreeWithAuth.add(specialParams.get(0));
            flightStepThreeWithAuth.add(specialParams.get(1));
            flightStepThreeWithAuth.add(id);
        }

        return flightStepThreeWithAuth;
    }

    public void CreateStepThreeWithoutCsv() throws JSONException {
        String id = new CreateFlights().CreateStepTwo().get(8);

        given().when().post(id + "/csv-segment").then().extract().response();
    }

    public ArrayList<String> CreateStepFourWithoutTech() throws JSONException {
        ArrayList<String> flightStepFourWithoutTech = new ArrayList<>();
        String id = new CreateFlights().CreateStepThreeWithAuth().get(3);
        String body = new CreateFlightStepFourTechParams().getFlightWithOutParameters().toString();

        Response response = given().body(body).when().post(id + "/segments/tech").then().extract().response();

        flightStepFourWithoutTech.add(response.path("selections[0].categoryUuid"));
        flightStepFourWithoutTech.add(response.path("selections[0].filters").toString());
        flightStepFourWithoutTech.add(response.path("selections[1].categoryUuid"));
        flightStepFourWithoutTech.add(response.path("selections[1].filters").toString());
        flightStepFourWithoutTech.add(response.path("segmentIdsMap").toString());
        flightStepFourWithoutTech.add(id);

        return flightStepFourWithoutTech;
    }

    public ArrayList<String> CreateStepFourWithTech() throws JSONException {
        ArrayList<String> flightStepFourWithTech = new ArrayList<>();
        String id = new CreateFlights().CreateStepThreeWithAuth().get(3);
        String body = new CreateFlightStepFourTechParams().getFlightWithParameters().toString();

        Response response = given().body(body).when().post(id + "/segments/tech").then().extract().response();

        if(response.path("segmentIdsMap.6b9abca0-6c55-4851-8cc5-bec56814510b")) {
            if(response.path("segmentIdsMap.f177e59d-102a-4364-be9f-35edefc15813"))
            {
                if(response.path("segmentIdsMap.502c85c4-bb22-4071-9590-86d5b122696a")) {
                    flightStepFourWithTech.add(response.path("selections[0].categoryUuid"));
                    flightStepFourWithTech.add(response.path("selections[0].filters.fromAppVer"));
                    flightStepFourWithTech.add(response.path("selections[0].filters.toAppVer"));
                    flightStepFourWithTech.add(response.path("selections[1].categoryUuid"));
                    flightStepFourWithTech.add(response.path("selections[1].filters.fromAppVer"));
                    flightStepFourWithTech.add(response.path("selections[1].filters.toAppVer"));
                    flightStepFourWithTech.add(id);
                }
            }
        }

        return flightStepFourWithTech;
    }

    public ArrayList<String> CreateStepFiveGhostNone() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        ArrayList<String> flightStepFiveGhostNone = new ArrayList<>();
        String body = new CreateFlightStepFiveGhost().getFlightHideableTypeNone().toString();

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post("/flights/" + ids.get(0) + "/creatives").then().log().all().extract().response();

        if (!(Boolean) response.path("pages[0].showCross")) {
            flightStepFiveGhostNone.add(response.path("pages[0].pageName"));
            flightStepFiveGhostNone.add(response.path("pages[0].hideableType"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].url"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].type"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].link.linkAddress"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[0].link.linkType"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[1].value"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[1].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[1].type"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[2].value"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[2].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[2].type"));

            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].elementId"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].type"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].link.linkAddress"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].link.linkType"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].style.code"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].style.backGroundColor"));
            flightStepFiveGhostNone.add(response.path("pages[0].elements[3].style.fontColor"));

            flightStepFiveGhostNone.add(response.path("name"));
            flightStepFiveGhostNone.add(response.path("theme"));
            flightStepFiveGhostNone.add(response.path("offerType"));
        }

        return flightStepFiveGhostNone;
    }

    public String CreateStepFiveGhostWithoutPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String flightStepFiveGhostWithOutPolling = "";
        String body = new CreateFlightStepFiveGhost().getFlightHideableTypeWithOutPolling().toString();

        Response response = given().body(body).queryParam("placementId", ids.get(1)).when()
                .post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");

        if((Boolean) response.path("pages[0].showCross")) {
            flightStepFiveGhostWithOutPolling = pages.get("hideableType").toString();
        }

        return flightStepFiveGhostWithOutPolling;
    }

    public String CreateStepFiveGhostWithPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveGhost().getFlightHideableTypeWithPolling().toString();
        String flightStepFiveGhostWithPolling = "";

        Response response = given().body(body).queryParam("placementId", ids.get(1)).when()
                .post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        if((Boolean) response.path("pages[0].showCross")) {
            flightStepFiveGhostWithPolling = response.path("pages[0].hideableType");
        }

        return flightStepFiveGhostWithPolling;
    }

    public ArrayList<String> CreateStepFivePrerollNone() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        ArrayList<String> flightStepFivePrerollNone = new ArrayList<>();
        String body = new CreateFlightStepFivePreroll().getFlightHideableTypeNone().toString();

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        if (!(Boolean) response.path("pages[0].showCross")) {
            flightStepFivePrerollNone.add(response.path("pages[0].pageName"));
            flightStepFivePrerollNone.add(response.path("pages[0].hideableType"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].url"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].type"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].link.linkAddress"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[0].link.linkType"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[1].value"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[1].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[1].type"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[2].value"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[2].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[2].type"));

            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].value"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].elementId"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].type"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].link.linkAddress"));
            flightStepFivePrerollNone.add(response.path("pages[0].elements[3].link.linkType"));

            flightStepFivePrerollNone.add(response.path("name"));
            flightStepFivePrerollNone.add(response.path("theme"));
            flightStepFivePrerollNone.add(response.path("offerType"));

            flightStepFivePrerollNone.add(ids.get(0));
        }

        return flightStepFivePrerollNone;
    }

    public String CreateStepFivePrerollWithOutPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String flightStepFivePrerollWithOutPolling = "";
        String body = new CreateFlightStepFivePreroll().getFlightHideableTypeWithOutPolling().toString();

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");

        if((Boolean) pages.get("showCross")) {
            flightStepFivePrerollWithOutPolling = pages.get("hideableType").toString();
        }

        return flightStepFivePrerollWithOutPolling;
    }

    public String CreateStepFivePrerollWithPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String flightStepFivePrerollWithPolling = "";
        String body = new CreateFlightStepFivePreroll().getFlightHideableTypeWithPolling().toString();

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");

        if((Boolean) pages.get("showCross")) {
            flightStepFivePrerollWithPolling = pages.get("hideableType").toString();
        }

        return flightStepFivePrerollWithPolling;
    }

    public ArrayList<String> CreateStepFiveSliderNone() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveSlider().getFlightHideableTypeNone().toString();
        ArrayList<String> flightStepFiveSliderNone = new ArrayList<>();

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        if (!(Boolean) response.path("pages[0].showCross")) {
            flightStepFiveSliderNone.add(response.path("pages[0].pageName"));
            flightStepFiveSliderNone.add(response.path("pages[0].hideableType"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[0].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[0].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[0].type"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[1].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[1].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[1].type"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].type"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].style.code"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].style.backGroundColor"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[2].style.fontColor"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].type"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].style.code"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].style.backGroundColor"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[3].style.fontColor"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[4].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[4].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[4].type"));

            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].value"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].elementId"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].type"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].link.linkAddress"));
            flightStepFiveSliderNone.add(response.path("pages[0].elements[5].link.linkType"));

            flightStepFiveSliderNone.add(response.path("name"));
            flightStepFiveSliderNone.add(response.path("theme"));
            flightStepFiveSliderNone.add(response.path("offerType"));
        }

        return flightStepFiveSliderNone;
    }

    public String CreateStepFiveSliderWithOutPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveSlider().getFlightHideableTypeWithOutPolling().toString();
        String flightStepFiveSliderWithOutPolling = "";

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");

        if((Boolean) pages.get("showCross")) {
            flightStepFiveSliderWithOutPolling = pages.get("hideableType").toString();
        }

        return flightStepFiveSliderWithOutPolling;
    }

    public String CreateStepFiveSliderWithPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveSlider().getFlightHideableTypeWithPolling().toString();
        String flightStepFiveSliderWithPolling = "";

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post("/flights/" + ids.get(0) + "/creatives").then().extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");

        if((Boolean) pages.get("showCross")) {
            flightStepFiveSliderWithPolling = pages.get("hideableType").toString();
        }

        return flightStepFiveSliderWithPolling;
    }

    public ArrayList<String> CreateStepSix() throws JSONException {
        String id = new CreateFlights().CreateStepFivePrerollNone().get(21);
        ArrayList<String> flightStepSix = new ArrayList<>();
        Response response = given().when().get("/flights/" + id + "/summary").then().extract().response();

        flightStepSix.add(response.path("basicInfo.name"));
        flightStepSix.add(response.path("basicInfo.frequency.term"));
        flightStepSix.add(response.path("placementInfo.channelName"));
        flightStepSix.add(response.path("placementInfo.places[0].locationName"));
        flightStepSix.add(response.path("placementInfo.places[0].positionName"));
        flightStepSix.add(response.path("placementInfo.places[0].formatName"));

        flightStepSix.add(response.path("socialSegmentsInfo.auditorial.extendedDescription.include[0].name"));
        flightStepSix.add(response.path("socialSegmentsInfo.auditorial.extendedDescription.include[0]" +
                ".children[0].name"));
        flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].os"));
        flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].versionsInclude.fromAppVer"));
        flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].versionsInclude.toAppVer"));
        flightStepSix.add(response.path("techSegmentsInfo.appInfo[0].versionsExclude"));
        flightStepSix.add(id);

        return flightStepSix;
    }
}
