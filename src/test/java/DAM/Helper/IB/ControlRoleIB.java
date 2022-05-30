package DAM.Helper.IB;

import DAM.Specification;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ControlRoleIB {

    public ControlRoleIB() {
        Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec403());
    }

    public String RemoveChannelModerator() {
        Response response = given().when().delete("/channels/c6535841-1989-4287-8c5e-51c30830c562")
                .then().extract().response();

        return response.path("errors[0].message");
    }

    public String RemoveLocationModerator() {
        Response response = given().when().delete("/locations/038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a")
                .then().extract().response();

        return response.path("errors[0].message");
    }

    public String RemovePositionModerator() {
        Response response = given().when().delete("/positions/89a2018f-55e8-4ac3-930e-006867a9c3ca")
                .then().extract().response();

        return response.path("errors[0].message");
    }

    public String RemoveFormatModerator() {
        Response response = given().when().delete("/formats/1721cf87-f07c-496a-8c29-2eb8a3cc15b0")
                .then().extract().response();

        return response.path("errors[0].message");
    }

    public String RemoveTemplateModerator() {
        Response response = given().when().delete("/templates/16bcdc2d-21e4-4f0c-a1e2-a3e53e755b1c")
                .then().extract().response();

        return response.path("errors[0].message");
    }

    public String CreateChannelModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("channel", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Channel.json"), "application/json")
                .when().post("/channels").then().extract().response();

        return response.path("errors[0].message");
    }

    public String CreateLocationModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("location", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Location.json"), "application/json")
                .when().post("/locations").then().extract().response();

        return response.path("errors[0].message");
    }

    public String CreatePositionModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("position", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Position.json"), "application/json")
                .when().post("/positions").then().extract().response();

        return response.path("errors[0].message");
    }

    public String CreateFormatModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("format", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Format.json"), "application/json")
                .when().post("/formats").then().extract().response();

        return response.path("errors[0].message");
    }

    public String CreateTemplateModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("template", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Template_GHOST.json"), "application/json")
                .when().post("/templates").then().extract().response();

        return response.path("errors[0].message");
    }

    public String EditChannelModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("channel", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Channel.json"), "application/json")
                .when().patch("/channels/c6535841-1989-4287-8c5e-51c30830c562").then().extract().response();

        return response.path("errors[0].message");
    }

    public String EditLocationModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("location", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Location.json"), "application/json")
                .when().patch("/locations/038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a").then().extract().response();

        return response.path("errors[0].message");
    }

    public String EditPositionModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("position", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Position.json"), "application/json")
                .when().patch("/positions/89a2018f-55e8-4ac3-930e-006867a9c3ca").then().extract().response();

        return response.path("errors[0].message");
    }

    public String EditFormatModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("format", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Format.json"), "application/json")
                .when().patch("/formats/1721cf87-f07c-496a-8c29-2eb8a3cc15b0").then().extract().response();

        return response.path("errors[0].message");
    }

    public String EditTemplateModerator() {
        Response response = given().contentType("multipart/form-data")
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("template", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\" +
                        "Template_GHOST.json"), "application/json")
                .when().patch("/templates/16bcdc2d-21e4-4f0c-a1e2-a3e53e755b1c").then().extract().response();

        return response.path("errors[0].message");
    }
}
