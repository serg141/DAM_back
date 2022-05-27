package DAM.Parametrs.Flights;

import DAM.Parametrs.Placements.GetTemplate;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class CreateFlightStepFivePreroll {
    final JSONObject flightHideableTypeNone = new JSONObject();
    final JSONObject flightHideableTypeWithOutPolling = new JSONObject();
    final JSONObject flightHideableTypeWithPolling = new JSONObject();

    public CreateFlightStepFivePreroll() throws JSONException {
        String prerollTemplate = new GetTemplate().getTemplatePreRoll();

        JSONObject link = new JSONObject();
        link.put("linkAddress", "Https:www.vtb.ru");
        link.put("linkType", "EXTERNAL");

        JSONObject elementImage = new JSONObject();
        elementImage.put("elementId", "preroll-image");
        elementImage.put( "type", "IMAGE");
        elementImage.put("url",
                "https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png");
        elementImage.put("link", link);

        JSONObject heading = new JSONObject();
        heading.put("elementId", "preroll-heading");
        heading.put("type", "TEXT");
        heading.put("value", "Заголовок");

        JSONObject description = new JSONObject();
        description.put("elementId", "preroll-description");
        description.put("type", "TEXT");
        description.put("value", "Описание");

        JSONObject button = new JSONObject();
        button.put("elementId", "preroll-button");
        button.put("type", "BUTTON");
        button.put("value", "Кнопка");
        button.put("link", link);

        JSONArray elements = new JSONArray();
        elements.put(elementImage);
        elements.put(heading);
        elements.put(description);
        elements.put(button);

        JSONObject page1 = new JSONObject();
        page1.put("page", 1);
        page1.put("pageName", 1);
        page1.put("showCross", false);
        page1.put("hideableType", "NONE");
        page1.put("templateId", prerollTemplate);
        page1.put("elements", elements);

        JSONObject page2 = new JSONObject();
        page2.put("page", 1);
        page2.put("pageName", 1);
        page2.put("showCross", true);
        page2.put("hideableType", "CROSS_WITHOUT_POLLING");
        page2.put("templateId", prerollTemplate);
        page2.put("elements", elements);

        JSONObject page3 = new JSONObject();
        page3.put("page", 1);
        page3.put("pageName", 1);
        page3.put("showCross", true);
        page3.put("hideableType", "CROSS_WITH_POLLING");
        page3.put("templateId", prerollTemplate);
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
