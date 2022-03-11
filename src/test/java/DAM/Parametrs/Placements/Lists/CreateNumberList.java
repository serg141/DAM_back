package DAM.Parametrs.Placements.Lists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateNumberList {
    final JSONObject numberedList = new JSONObject();
    final JSONObject element1 = new JSONObject();
    final JSONObject element2 = new JSONObject();

    public CreateNumberList() throws JSONException {

        element1.put("key", 3);
        element1.put("type", "TEXT");
        element1.put("description", "");
        element1.put("elementId", "title");
        element1.put("name", "Заголовок");
        element1.put("elementOrder", 1);
        element1.put("elementStyle", "LIST_ROW_TITLE");
        element1.put("required", true);
        element1.put("maxLength", 80);

        element2.put("key", 5);
        element2.put("type", "TEXT");
        element2.put("description", "");
        element2.put("elementId", "description2");
        element2.put("name", "Описание");
        element2.put("elementOrder", 2);
        element2.put("elementStyle", "LIST_ROW_DESCRIPTION");
        element2.put("required", false);
        element2.put("maxLength", 150);

        JSONArray element = new JSONArray();
        element.put(element1);
        element.put(element2);

        numberedList.put("name", "NumberedList");
        numberedList.put("code", "NUMBERED_LIST");
        numberedList.put("elements", element);
        numberedList.put("html", "<li class=\\\"numbered-list__item\\\">\\n   " +
                "<div class=\\\"numbered-list__wrapper\\\">\\n       " +
                "<p data-creative-id=\\\"title\\\" class=\\\"numbered-list__heading\\\">Подберите авто</p>\\n       " +
                "<p data-creative-id=\\\"description2\\\" class=\\\"numbered-list__description\\\"" +
                ">Из наличия или закажите индивидуальную комплектацию</p>\\n   </div>\\n</li>");
        numberedList.put("css", ".numbered-list__item::before {\n      content: \"1\";\n      color: #99A0AB;\n " +
                "     font-weight: bold;\n      font-size: 22px;\n      line-height: 28px;\n      " +
                "display: inline-block;\n      width: .5em;\n      margin-right: 30px;\n    }\n\n    " +
                ".numbered-list__item {\n      display: flex;\n      padding: 16px 0;\n    }\n\n    " +
                ".numbered-list__wrapper {\n      display: flex;\n      flex-direction: column;\n      " +
                "letter-spacing: 0.2px;\n      font-style: normal;\n    }\n\n    .numbered-list__heading {\n     " +
                " font-weight: 500;\n      font-size: 16px;\n      line-height: 20px;\n      margin: 0;\n      " +
                "margin-bottom: 4px;\n    }\n\n    .numbered-list__description {\n      margin: 0;\n      " +
                "font-weight: normal;\n      font-size: 14px;\n      line-height: 16px;\n      color: #99A0AB;\n    }");
    }

    public String getNumberedList() {
        return numberedList.toString();
    }
}
