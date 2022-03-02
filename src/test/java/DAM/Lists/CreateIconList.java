package DAM.Lists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateIconList {
    final JSONObject iconList = new JSONObject();
    final JSONObject element1 = new JSONObject();
    final JSONObject element2 = new JSONObject();
    final JSONObject imageSize = new JSONObject();

    public CreateIconList() throws JSONException {

        imageSize.put("width", 120);
        imageSize.put("height", 120);

        element1.put("key", 2);
        element1.put("type", "IMAGE");
        element1.put("description", "");
        element1.put("elementId", "image");
        element1.put("name", "Иконка");
        element1.put("elementOrder", 1);
        element1.put("elementStyle", "LIST_ROW_TITLE");
        element1.put("required", true);
        element1.put("size", imageSize);

        element2.put("key", 4);
        element2.put("type", "TEXT");
        element2.put("description", "");
        element2.put("elementId", "title");
        element2.put("name", "Заголовок");
        element2.put("elementOrder", 2);
        element2.put("elementStyle", "LIST_ROW_TITLE");
        element2.put("required", true);
        element2.put("maxLength", 80);

        JSONArray element = new JSONArray();
        element.put(element1);
        element.put(element2);

        iconList.put("name", "IconList");
        iconList.put("code", "ICON_LIST");
        iconList.put("elements", element);
        iconList.put("html", "<li class=\"icon-list__item\">\n" +
                "    <img data-creative-id=\"image\" src=\"./icon.png\" alt=\"\" class=\"icon-list__image\">\n" +
                "    <p data-creative-id=\"title\" class=\"icon-list__heading\">" +
                "Специальные условия на автокредит</p>\n </li>");
        iconList.put("css", ".icon-list__item {\n" +
                "      display: flex;\n" +
                "      flex-direction: row;\n" +
                "      align-items: center;\n" +
                "      min-height: 40px;\n" +
                "      padding: 12px 0;\n" +
                "    }\n" +
                ".icon-list__image {\n" +
                "      width: 24px;\n" +
                "      height: 24px;\n" +
                "      margin-right: 25px;\n" +
                "    }\n" +
                "\n" +
                "    .icon-list__heading {\n" +
                "      margin: 0;\n" +
                "      word-wrap: break-word;\n" +
                "    }");
    }

    public String getIconList() {
        return iconList.toString();
    }
}
