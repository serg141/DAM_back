package DAM;

import lombok.Data;

@Data
public final class EndPoints {
    private final String campaigns;
    private final String duplicate;
    private final String predict;
    private final String flights;
    private final String placement;
    private final String lists;
    private final String csvSegment;
    private final String checkCSV;
    private final String segmentSocial;
    private final String segmentsTech;
    private final String creative;
    private final String segmentCategories;
    private final String users;
    private final String list;

    public EndPoints() {
        campaigns = "/campaigns/";
        duplicate = "/duplicate/";
        predict = "/predict/";
        flights = "/flights/";
        placement = "/placement/";
        lists = "/lists/";
        csvSegment = "/csv-segment/";
        checkCSV = "check-csv/";
        segmentSocial = "/segments/social";
        segmentsTech = "/segments/tech";
        creative = "/creatives";
        segmentCategories = "/segment-categories/rootcategories";
        users = "/users";
        list = "/list";
    }
}
