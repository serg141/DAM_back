package Content.Helper;

import Content.Specification;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class FindFlightIdInActivator {
    List<ArrayList<String>> include;
    List<ArrayList<String>> exclude;
    List<ArrayList<String>> id;
    String flightId;

    public FindFlightIdInActivator() {
        Specification.installSpec(Specification.activator(), Specification.responseSpec200());

        Response response = given().when().get().then().extract().response();

        include = response.path("segments.include");
        exclude = response.path("segments.exclude");
        id = response.path("id");
    }

    public String Android15421() {
        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE:ANDROID_15.4.3") && include.get(i).contains("MOBILE:ANDROID_15.4.2") &&
                    include.get(i).contains("MOBILE_PLATFORM:ANDROID")) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }

    public String AndroidIOS() {
        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE_PLATFORM:IOS") && include.get(i).size() == 2 &&
                    include.get(i).contains("MOBILE_PLATFORM:ANDROID")) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }

    public String Birthday() {
        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("SPECIAL:BIRTHDAY")) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }

    public String IOS1542() {
        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE_PLATFORM:IOS") && include.get(i).size() == 3 &&
                    include.get(i).contains("MOBILE:IOS_15.4.2")) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }

    public String IOSAndroidVersions() {
        for (int i = 0; i < exclude.size(); i++) {
            if (exclude.get(i).contains("MOBILE:IOS_15.4.1") && exclude.get(i).contains("MOBILE:ANDROID_15.4.1")) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }

    public String MoneyBox() {
        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("SPEND:MONEYBOX")) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }

    public String OnlyAndroid() {
        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE_PLATFORM:ANDROID") && include.get(i).size() == 1) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }

    public String OnlyIOS() {
        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE_PLATFORM:IOS") && include.get(i).size() == 1) {
                flightId = String.valueOf(id.get(i));
            }
        }
        return flightId;
    }
}
