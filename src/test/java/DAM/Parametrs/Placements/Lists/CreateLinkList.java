package DAM.Parametrs.Placements.Lists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateLinkList {
    final JSONObject linkList = new JSONObject();
    final JSONObject element1 = new JSONObject();
    final JSONObject element2 = new JSONObject();

    public CreateLinkList() throws JSONException {

        element1.put("key", 9);
        element1.put("type", "BLOCK");
        element1.put("description", "");
        element1.put("elementId", "body");
        element1.put("name", "Фон ссылки");
        element1.put("elementOrder", 1);
        element1.put("elementStyle", "");
        element1.put("required", true);

        element2.put("key", 11);
        element2.put("type", "TEXT");
        element2.put("description", "");
        element2.put("elementId", "description");
        element2.put("name", "Ссылка");
        element2.put("elementOrder", 2);
        element2.put("elementStyle", "");
        element2.put("required", true);
        element2.put("maxLength", 32);

        JSONArray element = new JSONArray();
        element.put(element1);
        element.put(element2);

        linkList.put("name", "LinkList");
        linkList.put("code", "LINK_LIST");
        linkList.put("elements", element);
        linkList.put("html", "<li class=\"link\">\n" +
                "<div class=\"link__body\" data-creative-id=\"body\" >\n" +
                "<svg width=\"18\" height=\"20\" class=\"link__icon\" viewBox=\"0 0 16 16\" fill=\"none\"\n" +
                "xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "<path\n" +
                "d=\"M7.61328 10.9014L8.65918 9.8418C7.85254 9.77344 7.27148 9.50684 6.85449 9.08984C5.69922 " +
                "7.93457 5.69922 6.30078 6.84766 5.15918L9.11719 2.88281C10.2725 1.73438 11.8994 1.72754 13.0547 " +
                "2.88281C14.2168 4.04492 14.2031 5.67188 13.0615 6.82031L11.8994 7.97559C12.1182 8.48145 12.1934 " +
                "9.09668 12.0703 9.62988L14.0254 7.68164C15.707 6.00684 15.7139 3.61426 14.0186 1.91895C12.3164 " +
                "0.216797 9.9375 0.230469 8.25586 1.91211L5.87695 4.29102C4.19531 5.97266 4.18848 8.3584 5.88379 " +
                "10.0537C6.28027 10.457 6.82715 10.7578 7.61328 10.9014ZM8.24902 5.125L7.20312 6.18457C8.00977 " +
                "6.25977 8.59082 6.51953 9.00781 6.93652C10.1699 8.0918 10.1631 9.72559 9.01465 10.874L6.74512 " +
                "13.1436C5.58984 14.2988 3.96289 14.2988 2.81445 13.1436C1.65234 11.9814 1.65918 10.3613 2.80762 " +
                "9.21289L3.96289 8.05078C3.74414 7.55176 3.67578 6.93652 3.79199 6.39648L1.83691 8.35156C0.155273 " +
                "10.0264 0.148438 12.4121 1.84375 14.1074C3.5459 15.8096 5.9248 15.7959 7.60645 14.1211L9.98535 " +
                "11.7354C11.667 10.0537 11.6738 7.66797 9.97852 5.97266C9.58203 5.57617 9.04199 5.27539 8.24902 " +
                "5.125Z\" />\n </svg>\n \n <p class=\"link__text\" data-creative-id=\"description\">" +
                "Скачать презентацию</p>\n </div>\n </li>");
        linkList.put("css", ".link {\n list-style: none;\n margin-right: 5px;\n margin-bottom: 5px;\n" +
                "}\n .link__body {\n padding: 4px 16px 4px 12px;\n border-radius: 8px;\n" +
                "display: inline-flex;\n justify-content: space-between;\n align-items: center;\n" +
                "font-size: 14px;\n background-color: #99A0AB;\n }\n \n .link__text {\n" +
                "padding: 0;\n margin: 0;\n }\n \n .link__icon {\n margin-right: 4px;\n" +
                "fill: #2F3441;\n }\n \n");
    }

    public String getLinkList() {
        return linkList.toString();
    }
}
