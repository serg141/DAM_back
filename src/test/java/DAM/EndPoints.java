package DAM;

import lombok.Data;

import java.util.LinkedHashMap;

@Data
public final class EndPoints {
    private final String campaigns;
    private final String channels;
    private final String checkCSV;
    private final String creative;
    private final String csvSegment;
    private final String duplicate;
    private final String flights;
    private final String list;
    private final String lists;
    private final String login;
    private final String logout;
    private final String me;
    private final String notifications;
    private final String placement;
    private final String predict;
    private final String role;
    private final String reactivate;
    private final String segmentCategories;
    private final String segmentSocial;
    private final String segmentTech;
    private final String summary;
    private final String teams;
    private final String techReport;
    private final String template;
    private final String users;
    private final LinkedHashMap<String,Object> test;

    private String id;

    public EndPoints() {
        login = "/login";
        me = "/me";
        logout = "/logout";
        campaigns = "/campaigns/";
        duplicate = "/duplicate/";
        predict = "/predict/";
        flights = "/flights/";
        placement = "/placement/";
        lists = "/lists/";
        csvSegment = "/csv-segment/";
        checkCSV = "check-csv/";
        segmentSocial = "/segments/social";
        segmentTech = "/segments/tech";
        creative = "/creatives";
        segmentCategories = "/segment-categories/rootcategories";
        users = "/users";
        list = "/list";
        test = null;
        role = "/role";
        teams = "/teams";
        reactivate = "/support/flights/reactivate";
        techReport = "/tech-report";
        notifications = "/notifications";
        summary = "/summary";
        channels = "/channels";
        template = "/templates";
    }
}
