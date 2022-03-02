package DAM.autorization;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserData  {
    private String fullName;
    private String role;
    private String login;
    private String message;
    private ArrayList<Object> adAuthorities;
    private ArrayList<Object> teams;
    private String id;

}
