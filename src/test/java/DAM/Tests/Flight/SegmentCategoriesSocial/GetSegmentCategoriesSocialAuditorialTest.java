package DAM.Tests.Flight.SegmentCategoriesSocial;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetSegmentCategoriesSocialAuditorialTest {
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

        LinkedHashMap<String,Object> auditorialSpend = response.path("AUDITORIAL[0]");
        LinkedHashMap<String,Object> special = response.path("AUDITORIAL[1]");
        LinkedHashMap<String,Object> clientType = response.path("AUDITORIAL[2]");
        LinkedHashMap<String,Object> auditorialProductType = response.path("AUDITORIAL[3]");

        assertEquals("SPEND", auditorialSpend.get("code"));
        assertEquals("Траты клиента", auditorialSpend.get("name"));
        assertEquals("Траты клиента", auditorialSpend.get("description"));
        assertEquals("SOCIAL", auditorialSpend.get("type"));
        assertEquals("AUDITORIAL", auditorialSpend.get("subtype"));

        assertEquals("SPECIAL", special.get("code"));
        assertEquals("Специальные сегменты", special.get("name"));
        assertEquals("Специальные сегменты", special.get("description"));
        assertEquals("SOCIAL", special.get("type"));
        assertEquals("AUDITORIAL", special.get("subtype"));

        assertEquals("CLIENT_TYPE", clientType.get("code"));
        assertEquals("По типу клиента", clientType.get("name"));
        assertEquals("Типы клиентов", clientType.get("description"));
        assertEquals("SOCIAL", clientType.get("type"));
        assertEquals("AUDITORIAL", clientType.get("subtype"));

        assertEquals("PRODUCT_TYPE", auditorialProductType.get("code"));
        assertEquals("По типам продуктов", auditorialProductType.get("name"));
        assertEquals("Клиенты в зависимости от типа продукта", auditorialProductType.get("description"));
        assertEquals("SOCIAL", auditorialProductType.get("type"));
        assertEquals("AUDITORIAL", auditorialProductType.get("subtype"));
    }
}
