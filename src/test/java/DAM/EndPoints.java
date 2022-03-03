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

    public EndPoints() {
        campaigns = "/campaigns/";
        duplicate = "/duplicate/";
        predict = "/predict/";
        flights = "/flights/";
        placement = "/placement/";
        lists = "/lists/";
    }
}
