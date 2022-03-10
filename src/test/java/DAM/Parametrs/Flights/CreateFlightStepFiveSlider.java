package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepFiveSlider {
    final JSONObject flightHideableTypeNone = new JSONObject();
    final JSONObject flightHideableTypeWithOutPolling = new JSONObject();
    final JSONObject flightHideableTypeWithPolling = new JSONObject();
    final JSONObject page1 = new JSONObject();
    final JSONObject page2 = new JSONObject();
    final JSONObject page3 = new JSONObject();
    final JSONObject heading = new JSONObject();
    final JSONObject description = new JSONObject();
    final JSONObject body = new JSONObject();
    final JSONObject labelBody = new JSONObject();
    final JSONObject labelText = new JSONObject();
    final JSONObject link = new JSONObject();
    final JSONObject button = new JSONObject();

    public CreateFlightStepFiveSlider() throws JSONException {
        link.put("linkAddress", "2");
        link.put("linkType", "DEEPLINK");

        heading.put("elementId", "heading");
        heading.put("type", "TEXT");
        heading.put("value", "Заголовок");
        description.put("elementId", "description");
        description.put("type", "TEXT");
        description.put("value", "Описание");
        body.put("elementId", "body");
        body.put("type", "BLOCK");
        body.put("style", "FUCHSIA");
        labelBody.put("elementId", "label-body");
        labelBody.put("type", "BLOCK");
        labelBody.put("style", "ORANGE");
        labelText.put("elementId", "label-text");
        labelText.put("type", "TEXT");
        labelText.put("value", "Метка");
        button.put("elementId", "primary-button");
        button.put("type", "BUTTON");
        button.put("value", "Кнопка");
        button.put("link", link);

        JSONArray elements = new JSONArray();
        elements.put(heading);
        elements.put(description);
        elements.put(body);
        elements.put(labelBody);
        elements.put(labelText);
        elements.put(button);

        page1.put("page", 1);
        page1.put("pageName", 1);
        page1.put("showCross", false);
        page1.put("hideableType", "NONE");
        page1.put("templateId", "772c92df-96aa-4527-a015-0e64d53cca1f");
        page1.put("elements", elements);

        page2.put("page", 1);
        page2.put("pageName", 1);
        page2.put("showCross", true);
        page2.put("hideableType", "CROSS_WITHOUT_POLLING");
        page2.put("templateId", "772c92df-96aa-4527-a015-0e64d53cca1f");
        page2.put("elements", elements);

        page3.put("page", 1);
        page3.put("pageName", 1);
        page3.put("showCross", true);
        page3.put("hideableType", "CROSS_WITH_POLLING");
        page3.put("templateId", "772c92df-96aa-4527-a015-0e64d53cca1f");
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
