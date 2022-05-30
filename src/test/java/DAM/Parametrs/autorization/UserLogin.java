package DAM.Parametrs.autorization;

import lombok.Data;

@Data
public class UserLogin {
    private String login, pass;

    public void UserLoginUnCorrectPassword() {
        this.login = "vtb4040204@corp.dev.vtb";
        this.pass = "TTT";
    }

    public void UserLoginUnCorrectLogin() {
        this.login = "vtb4040204";
        this.pass = "admin";
    }
}
