package DAM.Helper.Flights;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;

import static io.restassured.RestAssured.given;

@Data
public class CopyFlights {
   String status;
   public CopyFlights(String body) {
      Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec200());

      Response response = given().body(body).when()
              .post("/campaigns/all?pageSize=100&sortBy=modifiedTime&sortDirection=DESC")
              .then().extract().response();
      String flightId = response.path("content[0].flights[0].id");

      response = given().when().put("/flights/" + flightId + "/duplicate").then().extract().response();
      status = response.path("data");
   }
}
