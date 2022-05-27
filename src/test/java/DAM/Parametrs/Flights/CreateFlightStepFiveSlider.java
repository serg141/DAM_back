package DAM.Parametrs.Flights;

import DAM.Parametrs.Placements.GetTemplate;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class CreateFlightStepFiveSlider {
    final JSONObject flightHideableTypeNone = new JSONObject();
    final JSONObject flightHideableTypeWithOutPolling = new JSONObject();
    final JSONObject flightHideableTypeWithPolling = new JSONObject();

    public CreateFlightStepFiveSlider() throws JSONException {
        String sliderTemplate = new GetTemplate().getTemplateSlider();

        JSONObject link = new JSONObject();
        link.put("linkAddress", "2");
        link.put("linkType", "DEEPLINK");

        JSONObject heading = new JSONObject();
        heading.put("elementId", "heading");
        heading.put("type", "TEXT");
        heading.put("value", "Заголовок");

        JSONObject description = new JSONObject();
        description.put("elementId", "description");
        description.put("type", "TEXT");
        description.put("value", "Описание");

        JSONObject body = new JSONObject();
        body.put("elementId", "body");
        body.put("type", "BLOCK");
        body.put("style", "FUCHSIA");

        JSONObject labelBody = new JSONObject();
        labelBody.put("elementId", "label-body");
        labelBody.put("type", "BLOCK");
        labelBody.put("style", "ORANGE");

        JSONObject labelText = new JSONObject();
        labelText.put("elementId", "label-text");
        labelText.put("type", "TEXT");
        labelText.put("value", "Метка");

        JSONObject button = new JSONObject();
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

        JSONObject page1 = new JSONObject();
        page1.put("page", 1);
        page1.put("pageName", 1);
        page1.put("showCross", false);
        page1.put("hideableType", "NONE");
        page1.put("templateId", sliderTemplate);
        page1.put("elements", elements);

        JSONObject page2 = new JSONObject();
        page2.put("page", 1);
        page2.put("pageName", 1);
        page2.put("showCross", true);
        page2.put("hideableType", "CROSS_WITHOUT_POLLING");
        page2.put("templateId", sliderTemplate);
        page2.put("elements", elements);

        JSONObject page3 = new JSONObject();
        page3.put("page", 1);
        page3.put("pageName", 1);
        page3.put("showCross", true);
        page3.put("hideableType", "CROSS_WITH_POLLING");
        page3.put("templateId", sliderTemplate);
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
}
