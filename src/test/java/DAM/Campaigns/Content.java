package DAM.Campaigns;

import java.util.ArrayList;

public class Content {
    private String id;
    private String name;
    private int priority;
    private Period period;
    private String status;
    private String type;
    private ArrayList<Object> flights;
    private String createdBy;

    public static class Period{
        private Object start;
        private Object end;

        public Object getStart() {
            return start;
        }

        public Object getEnd() {
            return end;
        }
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

    public ArrayList<Object> getFlights() {
        return flights;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
