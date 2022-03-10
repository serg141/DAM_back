package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepFiveGhost {
    final JSONObject flightHideableTypeNone = new JSONObject();
    final JSONObject flightHideableTypeWithOutPolling = new JSONObject();
    final JSONObject flightHideableTypeWithPolling = new JSONObject();
    final JSONObject page1 = new JSONObject();
    final JSONObject page2 = new JSONObject();
    final JSONObject page3 = new JSONObject();
    final JSONObject elementImage = new JSONObject();
    final JSONObject heading = new JSONObject();
    final JSONObject description = new JSONObject();
    final JSONObject body = new JSONObject();
    final JSONObject link = new JSONObject();

    public CreateFlightStepFiveGhost() throws JSONException {
        link.put("linkAddress", "2");
        link.put("linkType", "INTERNAL");

        elementImage.put("elementId", "image");
        elementImage.put( "type", "IMAGE");
        elementImage.put("url",
                "https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png");
        elementImage.put("link", link);
        heading.put("elementId", "heading");
        heading.put("type", "TEXT");
        heading.put("value", "Заголовок");
        description.put("elementId", "description");
        description.put("type", "TEXT");
        description.put("value", "Описание");
        body.put("elementId", "body");
        body.put("type", "BLOCK");
        body.put("style", "TIFFANY");
        body.put("link", link);

        JSONArray elements = new JSONArray();
        elements.put(elementImage);
        elements.put(heading);
        elements.put(description);
        elements.put(body);

        page1.put("page", 1);
        page1.put("pageName", 1);
        page1.put("showCross", false);
        page1.put("hideableType", "NONE");
        page1.put("templateId", "7f2db9fd-d6b4-4174-8bc6-24db0e3e521e");
        page1.put("elements", elements);

        page2.put("page", 1);
        page2.put("pageName", 1);
        page2.put("showCross", true);
        page2.put("hideableType", "CROSS_WITHOUT_POLLING");
        page2.put("templateId", "7f2db9fd-d6b4-4174-8bc6-24db0e3e521e");
        page2.put("elements", elements);

        page3.put("page", 1);
        page3.put("pageName", 1);
        page3.put("showCross", true);
        page3.put("hideableType", "CROSS_WITH_POLLING");
        page3.put("templateId", "7f2db9fd-d6b4-4174-8bc6-24db0e3e521e");
        page3.put("elements", elements);

        JSONArray pageNone = new JSONArray();
        pageNone.put(page1);
        JSONArray pageWithOutPoling = new JSONArray();
        pageWithOutPoling.put(page2);
        JSONArray pageWithPoling = new JSONArray();
        pageWithPoling.put(page3);

        flightHideableTypeNone.put("name", "Creative");
        flightHideableTypeNone.put("offerType", "");
        flightHideableTypeNone.put("pages", pageNone);
        flightHideableTypeNone.put("theme", "LIGHT_THEME");

        flightHideableTypeWithOutPolling.put("name", "Creative");
        flightHideableTypeWithOutPolling.put("offerType", "");
        flightHideableTypeWithOutPolling.put("pages", pageWithOutPoling);
        flightHideableTypeWithOutPolling.put("theme", "LIGHT_THEME");

        flightHideableTypeWithPolling.put("name", "Creative");
        flightHideableTypeWithPolling.put("offerType", "");
        flightHideableTypeWithPolling.put("pages", pageWithPoling);
        flightHideableTypeWithPolling.put("theme", "LIGHT_THEME");
    }

    public String getFlightHideableTypeNone() {
        return flightHideableTypeNone.toString();
    }
    public String getFlightHideableTypeWithOutPolling() {
        return flightHideableTypeWithOutPolling.toString();
    }
    public String getFlightHideableTypeWithPolling() {
        return flightHideableTypeWithPolling.toString();
    }
}
