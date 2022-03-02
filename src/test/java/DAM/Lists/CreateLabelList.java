package DAM.Lists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateLabelList {
    final JSONObject labelList = new JSONObject();
    final JSONObject element1 = new JSONObject();
    final JSONObject element2 = new JSONObject();

    public CreateLabelList() throws JSONException {

        element1.put("key", 9);
        element1.put("type", "BLOCK");
        element1.put("description", "");
        element1.put("elementId", "body");
        element1.put("name", "Фон метки");
        element1.put("elementOrder", 1);
        element1.put("elementStyle", "");
        element1.put("required", true);

        element2.put("key", 11);
        element2.put("type", "TEXT");
        element2.put("description", "");
        element2.put("elementId", "description");
        element2.put("name", "Метка");
        element2.put("elementOrder", 2);
        element2.put("elementStyle", "");
        element2.put("required", true);
        element2.put("maxLength", 24);

        JSONArray element = new JSONArray();
        element.put(element1);
        element.put(element2);

        labelList.put("name", "LabelList");
        labelList.put("code", "LABEL_LIST");
        labelList.put("elements", element);
        labelList.put("html", "<li class=\\\"label\\\">\\n<div data-creative-id=\\\"body\\\" " +
                "class=\\\"label__body\\\">\\n<p data-creative-id=\\\"description\\\" class=\\\"label__text\\\">" +
                "\\nОдобрено вам\\n</p>\\n</div>\\n</li>\\n\\n");
        labelList.put("css", ".label {\\nlist-style: none;\\nmargin-right: 5px;\\nmargin-bottom: 5px;\\n}" +
                "\\n.label__body {\\ndisplay: inline-block;\\npadding: 4px 8px;\\nbackground-color: #45BF78;" +
                "\\nborder-radius: 8px;\\nmargin-bottom: 12px;\\n}\\n.label__text {\\nmargin: 0;\\nline-height: " +
                "12px;\\nfont-size: 12px;\\ncolor: #ffffff;\\n}");
    }

    public String getLabelList() {
        return labelList.toString();
    }
}
