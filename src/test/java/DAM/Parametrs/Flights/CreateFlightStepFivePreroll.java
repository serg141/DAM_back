package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepFivePreroll {
    final JSONObject flight = new JSONObject();
    final JSONObject page1 = new JSONObject();
    final JSONObject elementImage = new JSONObject();
    final JSONObject heading = new JSONObject();
    final JSONObject description = new JSONObject();
    final JSONObject button = new JSONObject();
    final JSONObject link = new JSONObject();

    public CreateFlightStepFivePreroll() throws JSONException {
        link.put("linkAddress", "Https:www.vtb.ru");
        link.put("linkType", "EXTERNAL");

        elementImage.put("elementId", "preroll-image");
        elementImage.put( "type", "IMAGE");
        elementImage.put("url",
                "https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png");
        elementImage.put("link", link);
        heading.put("elementId", "preroll-heading");
        heading.put("type", "TEXT");
        heading.put("value", "Заголовок");
        description.put("elementId", "preroll-description");
        description.put("type", "TEXT");
        description.put("value", "Описание");
        button.put("elementId", "preroll-button");
        button.put("type", "BUTTON");
        button.put("value", "Кнопка");
        button.put("link", link);

        JSONArray elements = new JSONArray();
        elements.put(elementImage);
        elements.put(heading);
        elements.put(description);
        elements.put(button);

        page1.put("page", 1);
        page1.put("pageName", 1);
        page1.put("showCross", true);
        page1.put("hideableType", "CROSS_WITHOUT_POLLING");
        page1.put("templateId", "16bcdc2d-21e4-4f0c-a1e2-a3e53e755b1c");
        page1.put("elements", elements);

        JSONArray pages = new JSONArray();
        pages.put(page1);

        flight.put("name", "Creative");
        flight.put("offerType", "");
        flight.put("pages", pages);
        flight.put("theme", "LIGHT_THEME");
    }

    public String getFlight() {
        return flight.toString();
    }
}
