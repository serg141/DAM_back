package DAM.Helper.Filters;

import DAM.Parametrs.Filters.*;
import DAM.PojoClasses.AllCampaignsByCreatorId;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Filters {
    ArrayList<String> id, name;
    boolean status, placement, creater;
    int camp = 0, fl = 0;

    public ArrayList<String> FilterId() throws JSONException {
        String filterBody = new FilterByName().getBody2().toString();

        Specification.installSpec(Specification.requestFilter(), Specification.responseSpec200());

        Response response = given().body(filterBody).when().post().then().extract().response();

        id = response.path("content.id");

        return id;
    }

    public ArrayList<String> FilterName() throws JSONException {
        String filterBody = new FilterByName().getBody1().toString();

        Response response = given().body(filterBody).when().post().then().extract().response();

        name = response.path("content.name");

        return name;
    }

    public boolean FilterStatus() throws JSONException {
        String filterBody = new FilterByStatuses().getBody().toString();
        String flight;

        Response response = given().body(filterBody).when().post().then().extract().response();

        flight = response.path("content.flights.status").toString();

        if (!flight.contains("DECLINED") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("PENDING")
                && !flight.contains("MODERATION_CLAIMED") && !flight.contains("DRAFT")
                && !flight.contains("FINISHED") && !flight.contains("REMOVED")) {
            status = true;
        }

        return status;
    }

    public int CampStatus() throws JSONException {
        String filterBody = new FilterByCampStatus().getBody1().toString();
        List<String> campaign;

        Response response = given().body(filterBody).when().post().then().extract().response();
        campaign = response.path("content.status");

        if (!campaign.contains("ACTIVE") && !campaign.contains("REMOVED") && !campaign.contains("FINISHED")) {
            camp++;
        }

        filterBody = new FilterByCampStatus().getBody2().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        campaign = response.path("content.status");

        if (!campaign.contains("DRAFT") && !campaign.contains("REMOVED") && !campaign.contains("FINISHED")) {
            camp++;
        }

        filterBody = new FilterByCampStatus().getBody3().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        campaign = response.path("content.status");

        if (!campaign.contains("DRAFT") && !campaign.contains("ACTIVE") && !campaign.contains("REMOVED")) {
            camp++;
        }

        filterBody = new FilterByCampStatus().getBody4().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        campaign = response.path("content.status");

        if (!campaign.contains("DRAFT") && !campaign.contains("ACTIVE") && !campaign.contains("FINISHED")) {
            camp++;
        }

        return camp;
    }

    public int FlightStatus() throws JSONException {
        String filterBody = new FilterByFlightStatus().getBody1().toString();
        List<String> flight;

        Response response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("DECLINED") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("PAUSED") &&
                !flight.contains("PENDING") && !flight.contains("MODERATION_CLAIMED") &&
                !flight.contains("DRAFT") && !flight.contains("FINISHED") && !flight.contains("REMOVED")) {
            fl++;
        }

        filterBody = new FilterByFlightStatus().getBody2().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("ACTIVE") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("PAUSED") &&
                !flight.contains("PENDING") && !flight.contains("MODERATION_CLAIMED") &&
                !flight.contains("DRAFT") && !flight.contains("FINISHED") && !flight.contains("REMOVED")) {
            fl++;
        }

        filterBody = new FilterByFlightStatus().getBody3().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("ACTIVE") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("DECLINED") &&
                !flight.contains("PENDING") && !flight.contains("MODERATION_CLAIMED") &&
                !flight.contains("DRAFT") && !flight.contains("FINISHED") && !flight.contains("REMOVED")) {
            fl++;
        }

        filterBody = new FilterByFlightStatus().getBody4().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("ACTIVE") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("DECLINED") &&
                !flight.contains("PAUSED") && !flight.contains("MODERATION_CLAIMED") &&
                !flight.contains("DRAFT") && !flight.contains("FINISHED") && !flight.contains("REMOVED")) {
            fl++;
        }

        filterBody = new FilterByFlightStatus().getBody5().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("ACTIVE") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("DECLINED") &&
                !flight.contains("PAUSED") && !flight.contains("PENDING") &&
                !flight.contains("DRAFT") && !flight.contains("FINISHED") && !flight.contains("REMOVED")) {
            fl++;
        }

        filterBody = new FilterByFlightStatus().getBody6().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("ACTIVE") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("DECLINED") &&
                !flight.contains("PAUSED") && !flight.contains("PENDING") &&
                !flight.contains("MODERATION_CLAIMED") && !flight.contains("FINISHED") && !flight.contains("REMOVED")) {
            fl++;
        }

        filterBody = new FilterByFlightStatus().getBody7().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("ACTIVE") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("DECLINED") &&
                !flight.contains("PAUSED") && !flight.contains("PENDING") &&
                !flight.contains("MODERATION_CLAIMED") && !flight.contains("DRAFT") && !flight.contains("REMOVED")) {
            fl++;
        }

        filterBody = new FilterByFlightStatus().getBody8().toString();
        response = given().body(filterBody).when().post().then().extract().response();
        flight = response.path("content.flights.status");
        if (!flight.contains("ACTIVE") && !flight.contains("MODERATION_INPROGRESS") && !flight.contains("DECLINED") &&
                !flight.contains("PAUSED") && !flight.contains("PENDING") &&
                !flight.contains("MODERATION_CLAIMED") && !flight.contains("DRAFT") && !flight.contains("FINISHED")) {
            fl++;
        }

        return fl;
    }

    public boolean FilterPlacements() throws JSONException {
        String filterBody = new FilterByPlacement().getBody().toString();
        List<String> channel, location, position, format;

        Response response = given().body(filterBody).when().post().then().extract().response();

        channel = response.path("content.flights[0].placement.code");
        location = response.path("content.flights[0].placement.locations[0].code");
        position = response.path("content.flights[0].placement.locations[0].positions[0].code");
        format = response.path("content.flights[0].placement.locations[0].positions[0].formats[0].code");


            if (channel.get(0).contains("MOBILE") && location.get(0).contains("MAIN_PAGE")
                    && position.get(0).contains("FULL_SCREEN") && format.get(0).contains("PRE-ROLL_INFO_1")) {
                placement = true;
            }

        return placement;
    }

    public boolean FilterCreatorId() throws JSONException {
        String filterBody = new FilterByCreator().getBody().toString();
        List<String> createdByFl;

        List<AllCampaignsByCreatorId> content = given().body(filterBody).when().post().then()
                .extract().body().jsonPath().getList("content", AllCampaignsByCreatorId.class);

        createdByFl = content.stream().map(AllCampaignsByCreatorId::getCreatedBy).collect(Collectors.toList());

        for (int i = 0; i < createdByFl.size(); i++) {
            if (createdByFl.contains("Камынин Сергей Игоревич")) {
                creater = true;
            }
            else {
                creater = false;
                break;
            }
        }

        return creater;
    }
}
