package DAM.Tests.Flight.SegmentCategoriesSocial.Auditorial;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetSegmentCategoriesSocialSpendTest {
    String logIn, segmentCategories;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        segmentCategories = new EndPoints().getSegmentCategories();
    }

    @Test
    public void getSegmentCategoriesSocial() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .queryParam("type", "SOCIAL")
                .when()
                .get(segmentCategories)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> segmentEduSP = response.path("AUDITORIAL[0].segments[0]");
        LinkedHashMap<String,Object> segmentHealthSP = response.path("AUDITORIAL[0].segments[1]");
        LinkedHashMap<String,Object> segmentMoneybox = response.path("AUDITORIAL[0].segments[2]");
        LinkedHashMap<String,Object> segmentNoMoneybox = response.path("AUDITORIAL[0].segments[3]");

        assertEquals("NO_MONEYBOX", segmentNoMoneybox.get("code"));
        assertEquals("Нет счета \"Копилка\"", segmentNoMoneybox.get("name"));
        //assertEquals("Счет \"Копилка\" ЕСТЬ", segmentNoMoneybox.get("description"));

        assertEquals("MONEYBOX", segmentMoneybox.get("code"));
        assertEquals("Есть счет \"Копилка\"", segmentMoneybox.get("name"));
        assertEquals("Счет \"Копилка\" ЕСТЬ", segmentMoneybox.get("description"));

        assertEquals("HEALTH_SP", segmentHealthSP.get("code"));
        assertEquals("Траты ДС на лечение", segmentHealthSP.get("name"));
        assertEquals("Траты ДС на лечение", segmentHealthSP.get("description"));

        assertEquals("EDU_SP", segmentEduSP.get("code"));
        assertEquals("Траты ДС на образование", segmentEduSP.get("name"));
        assertEquals("Траты ДС на образование", segmentEduSP.get("description"));
    }
}
