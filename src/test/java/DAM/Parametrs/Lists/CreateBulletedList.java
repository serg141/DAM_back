package DAM.Parametrs.Lists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateBulletedList {
    final JSONObject bulletedList = new JSONObject();
    final JSONObject element1 = new JSONObject();

    public CreateBulletedList() throws JSONException {

        element1.put("key", 2);
        element1.put("type", "TEXT");
        element1.put("description", "");
        element1.put("elementId", "description");
        element1.put("name", "Заголовок списка");
        element1.put("elementOrder", 1);
        element1.put("elementStyle", "LIST_ROW_TITLE");
        element1.put("required", true);
        element1.put("maxLength", 80);

        JSONArray element = new JSONArray();
        element.put(element1);

        bulletedList.put("name", "BulletedList");
        bulletedList.put("code", "BULLETED_LIST");
        bulletedList.put("elements", element);
        bulletedList.put("html", "<li class=\"bulleted-list__item\">\n   <p data-creative-id=\"description\" " +
                "class=\"bulleted-list__heading\">Подберите авто</p>\n</li>");
        bulletedList.put("css", ".bulleted-list__item {\n      padding: 8px 0;\n      display: flex;\n    }\n\n   " +
                " .bulleted-list__item::before {\n      content: \"\\2022\";\n      color: #99A0AB;\n    " +
                "  font-weight: bold;\n      display: inline-block;\n      width: .5em;\n    " +
                "  margin-right: 15px;\n    }\n\n    .bulleted-list__heading {\n      margin: 0;\n    }");
    }

    public String getBulletedList() {
        return bulletedList.toString();
    }
}
