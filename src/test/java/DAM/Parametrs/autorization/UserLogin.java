package DAM.Parametrs.autorization;

import lombok.Data;

@Data
public class UserLogin {
    private String login, pass;

    public void UserLoginCorrect() {
        this.login = "vtb4040204";
        this.pass = "141523Pota#";
    }

    public void UserLoginUnCorrectPassword() {
        this.login = "vtb4040204";
        this.pass = "141523Pota";
    }

    public void UserLoginUnCorrectLogin() {
        this.login = "vtb404020";
        this.pass = "141523Pota#";
    }
}
