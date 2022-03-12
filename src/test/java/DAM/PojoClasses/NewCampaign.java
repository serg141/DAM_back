package DAM.PojoClasses;

import java.util.ArrayList;

public class NewCampaign {
    private String id;
    private String name;
    private int priority;
    private Period period;
    private String status;
    private String type;
    private ArrayList<Object> flights;
    private String createdBy;

    public String getName() {
           return name;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Period getPeriod() {
        return period;
    }

    public ArrayList<Object> getFlights() {
        return flights;
    }

    public static class Period{
         private long start;
         private long end;

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }
    }
}
