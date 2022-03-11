package DAM.Tests.Flight.CreateFlight;

import DAM.EndPoints;
import DAM.Flights.CreateFlightStepSix;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepSixTest {
    String logIn, flights, id, summary;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightStepSix().getId();

        flights = new EndPoints().getFlights();
        summary = new EndPoints().getSummary();
    }

    @Test
    public void stepSixBasicInfo() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + summary)
                .then()
                .extract().response();

        int value = response.path("basicInfo.frequency.value");
        int priority = response.path("basicInfo.priority");

        assertEquals("FlightTest", response.path("basicInfo.name"));
        assertEquals("DAILY", response.path("basicInfo.frequency.term"));
        assertEquals(1, value);
        assertEquals(40, priority);
    }

    @Test
    public void stepSixPlacementInfo() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + summary)
                .then()
                .extract().response();

        assertEquals("Мобильный Банк", response.path("placementInfo.channelName"));
        assertEquals("Главный Экран", response.path("placementInfo.places[0].locationName"));
        assertEquals("Баннер при входе", response.path("placementInfo.places[0].positionName"));
        assertEquals("Информационный Pre-roll", response.path("placementInfo.places[0].formatName"));
    }

    @Test
    public void stepSixSocialSegmentsInfo() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + summary)
                .then()
                .extract().response();

        assertEquals("Траты клиента (Нет счета \"Копилка\")",
                response.path("socialSegmentsInfo.auditorial.shortDescription"));
        assertEquals("Траты клиента",
                response.path("socialSegmentsInfo.auditorial.extendedDescription[0].name"));
        assertEquals("Нет счета \"Копилка\"",
                response.path("socialSegmentsInfo.auditorial.extendedDescription[0].children[0].name"));
        assertEquals(true,
                response.path("socialSegmentsInfo.auditorial.extendedDescription[0].children[0].include"));
    }

    @Test
    public void stepSixTechSegmentsInfo() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + summary)
                .then()
                .extract().response();

        assertEquals("IOS", response.path("techSegmentsInfo.appInfo[0].os"));
        assertEquals("15.4.0", response.path("techSegmentsInfo.appInfo[0].versionsInclude.fromAppVer"));
        assertEquals("15.4.2", response.path("techSegmentsInfo.appInfo[0].versionsInclude.toAppVer"));
        assertEquals("15.4.1", response.path("techSegmentsInfo.appInfo[0].versionsExclude"));
        assertEquals("Android", response.path("techSegmentsInfo.appInfo[1].os"));
        assertEquals("15.4.0", response.path("techSegmentsInfo.appInfo[1].versionsInclude.fromAppVer"));
        assertEquals("15.4.2", response.path("techSegmentsInfo.appInfo[1].versionsInclude.toAppVer"));
        assertEquals("15.4.1", response.path("techSegmentsInfo.appInfo[1].versionsExclude"));
        assertEquals(true, response.path("techSegmentsInfo.arInfo"));
    }

    @Test
    public void stepSixCreativesInfo() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + summary)
                .then().log().all()
                .extract().response();

        assertEquals("Мобильный Банк", response.path("creativesInfo.channelName"));
        assertEquals("1721cf87-f07c-496a-8c29-2eb8a3cc15b0",
                response.path("creativesInfo.nodes[0].formatId"));
        assertEquals("Информационный Pre-roll",
                response.path("creativesInfo.nodes[0].formatName"));
        assertEquals("Баннер при входе",
                response.path("creativesInfo.nodes[0].positionName"));
        assertEquals("Главный Экран",
                response.path("creativesInfo.nodes[0].locationName"));
        assertEquals("Creative",
                response.path("creativesInfo.nodes[0].creativeItems[0].name"));
        assertEquals("LIGHT_THEME",
                response.path("creativesInfo.nodes[0].creativeItems[0].theme"));
        assertEquals("1",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].pageName"));
        assertEquals("16bcdc2d-21e4-4f0c-a1e2-a3e53e755b1c",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].templateId"));
        assertEquals(false,
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].showCross"));
        assertEquals("NONE",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].hideableType"));
        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[0].url"));
        assertEquals("preroll-image",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[0].elementId"));
        assertEquals("IMAGE",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[0].type"));
        assertEquals("Заголовок",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[1].value"));
        assertEquals("preroll-heading",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[1].elementId"));
        assertEquals("TEXT",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[1].type"));
        assertEquals("Описание",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[2].value"));
        assertEquals("preroll-description",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[2].elementId"));
        assertEquals("TEXT",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[2].type"));
        assertEquals("Кнопка",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[3].value"));
        assertEquals("preroll-button",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[3].elementId"));
        assertEquals("BUTTON",
                response.path("creativesInfo.nodes[0].creativeItems[0].pages[0].elements[3].type"));
    }
}
