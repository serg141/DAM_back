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

public class GetSegmentCategoriesSocialClientTypeTest {
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
                .then().statusCode(200)
                .extract().response();

        LinkedHashMap<String,Object> vtbEmployee = response.path("AUDITORIAL[2].segments[0]");
        LinkedHashMap<String,Object> vipClient = response.path("AUDITORIAL[2].segments[1]");
        LinkedHashMap<String,Object> blackList = response.path("AUDITORIAL[2].segments[2]");
        LinkedHashMap<String,Object> privilegeSet = response.path("AUDITORIAL[2].segments[3]");
        LinkedHashMap<String,Object> newClient = response.path("AUDITORIAL[2].segments[4]");

        assertEquals("NEW_CLIENT", newClient.get("code"));
        assertEquals("Новые клиенты", newClient.get("name"));
        assertEquals("Клиенты, оформившие недавно (менее 90 дней) новые договора без " +
                "оформления ДКО", newClient.get("description"));

        assertEquals("PRIVILEGE_SET", privilegeSet.get("code"));
        assertEquals("Привилегия", privilegeSet.get("name"));
        assertEquals("Флаг наличия у клиента пакета \"привилегия\"", privilegeSet.get("description"));

        assertEquals("BLACK_LIST", blackList.get("code"));
        assertEquals("Черный список", blackList.get("name"));
        assertEquals("Флаг наличия клиента в каком-то ЧС из широкого списка", blackList.get("description"));

        assertEquals("VIP_CLIENT", vipClient.get("code"));
        assertEquals("VIP-клиент", vipClient.get("name"));
        assertEquals("Флаг наличия клиента в картотеке ВИП-клиентов", vipClient.get("description"));

        assertEquals("VTB_EMPLOYEE", vtbEmployee.get("code"));
        assertEquals("Сотрудник ВТБ", vtbEmployee.get("name"));
        assertEquals("Признак сотрудника ВТБ", vtbEmployee.get("description"));
    }
}
