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

public class GetSegmentCategoriesSocialProductTypeTest {
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

        LinkedHashMap<String,Object> segmentNewProduct = response.path("AUDITORIAL[3].segments[0]");

        assertEquals("NEW_PRODUCT", segmentNewProduct.get("code"));
        assertEquals("Клиенты с новыми продуктами", segmentNewProduct.get("name"));
        assertEquals("Клиенты с новыми продуктами за последние 90 дней", segmentNewProduct.get("description"));
    }
}
