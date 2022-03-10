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

public class GetSegmentCategoriesSocialSpecialTest {
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

        LinkedHashMap<String,Object> multi = response.path("AUDITORIAL[1]");
        LinkedHashMap<String,Object> multiBonus = response.path("AUDITORIAL[1].segments[3]");
        LinkedHashMap<String,Object> salaryService = response.path("AUDITORIAL[1].segments[2]");
        LinkedHashMap<String,Object> refuseAD = response.path("AUDITORIAL[1].segments[1]");
        LinkedHashMap<String,Object> resultY = response.path("AUDITORIAL[1].segments[0]");

        assertEquals("MULTI_BONUS", multiBonus.get("code"));
        assertEquals("Клиент программы \"Мультибонус\"", multiBonus.get("name"));
        assertEquals("Зарегистрированый или активный клиент системы Мультибонус", multiBonus.get("description"));

        assertEquals("SALARY_SERVICE", salaryService.get("code"));
        assertEquals("Зарплатный клиент", salaryService.get("name"));
        assertEquals("Клиенты, на карты которых за последние 93 дня до отчетной даты была хотя бы одна " +
                "зарплатная транзакция на сумму 400 рублей и более", salaryService.get("description"));

        assertEquals("REFUSE_AD", refuseAD.get("code"));
        assertEquals("Отказ от рекламы", refuseAD.get("name"));
        assertEquals("Флаг того, что клиент отказался от целевых предложений", refuseAD.get("description"));

        assertEquals("RESULT_Y", resultY.get("code"));
        assertEquals("Клиент с итогами года", resultY.get("name"));
        assertEquals("В сегмент включаются клиенты, которые год по всем картам имеют не менее 5 расходных операций " +
                "на сумму от - для городов-миллионников - 10000р - для всех остальных - 5000р. Траты должны быть " +
                "как минимум в 5 разных категориях", resultY.get("description"));
    }
}
