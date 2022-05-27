package DAM.Helper.Flights;

import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CopyFlights {
   public CopyFlights() {
      Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec200());
   }

   public String CopyFlightDifferentStatus(String body) {
      String status;

      Response response = given().body(body).when()
              .post("/campaigns/all?pageSize=100&sortBy=modifiedTime&sortDirection=DESC")
              .then().extract().response();
      String flightId = response.path("content[0].flights[0].id");

      response = given().when().put("/flights/" + flightId + "/duplicate").then().extract().response();
      status = response.path("data");

      return status;
   }

   public String CopyFlightCSV() throws JSONException {
      String id = new CreateFlights().CreateStepThreeWithCsv().get(3);
      String status;

      Response response = given().when().put(id + "/duplicate").then().extract().response();
      status = response.path("data");

      return status;
   }
}
