package DAM.PojoClasses;

import java.util.ArrayList;

public class AllCampaignsByCreatorId {
    private String id;
    private String name;
    private int priority;
    private Period period;
    private String status;
    private String type;
    private ArrayList<Flight> flights;
    private String createdBy;

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public Period getPeriod() {
        return period;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public static class Flight{
        public String id;
        public String name;
        public String campaignId;
        public int priority;
        public Period period;
        public String status;
        public String purpose;
        public Frequency frequency;
        public String socialSegmentsOrigin;
        public int stage;
        public Placement placement;
        public String createdBy;

        public Flight() {
        }
    }

    public static class Period{
        public Object start;
        public Object end;
    }

    public static class Frequency{
        public String term;
        public int value;
    }

    public static class Format{
        public String id;
        public String name;
        public String code;
    }

    public static class Position{
        public String id;
        public String name;
        public String code;
        public ArrayList<Format> formats;
    }

    public static class Location{
        public String id;
        public String name;
        public String code;
        public ArrayList<Position> positions;
    }

    public static class Placement{
        public String id;
        public String name;
        public String code;
        public ArrayList<Location> locations;
    }
}
