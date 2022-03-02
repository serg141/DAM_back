package DAM;

import lombok.Data;

@Data
public final class EndPoints {
    private final String campaigns;
    private final String duplicate;
    private final String predict;
    private final String flights;
    private final String placement;

    public EndPoints() {
        campaigns = "/campaigns";
        duplicate = "/duplicate";
        predict = "/predict";
        flights = "/flights";
        placement = "/placement";
    }
}
