package DAM.PojoClasses;

import java.util.ArrayList;
import java.util.Date;

public class Users {
    private String login;
    private String fullName;
    private String role;
    private ArrayList<Object> teams;
    private String id;
    private Date modifiedTime;

    public String getLogin() {
        return login;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public ArrayList<Object> getTeams() {
        return teams;
    }

    public String getId() {
        return id;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }
}
