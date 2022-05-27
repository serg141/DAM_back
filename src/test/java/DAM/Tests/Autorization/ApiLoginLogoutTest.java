package DAM.Tests.Autorization;

import DAM.Helper.Autorizated.Correct;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

public class ApiLoginLogoutTest {

    @Test (priority = 1)
    public void LogIn() throws JSONException {

        ArrayList<String> userData = new Correct().CorrectLogIn();

        assertEquals("Камынин Сергей Игоревич", userData.get(0));
        assertEquals("REDACTOR", userData.get(1));
        assertEquals("vtb4040204@corp.dev.vtb", userData.get(2));
    }

    @Test (priority = 2)
    public void UnLogInPass() {

        String error = new Correct().UnCorrectPass();

        assertEquals("[Не удалось выполнить вход. Проверьте логин/пароль]", error);
    }

    @Test (priority = 2)
    public void UnLogIn(){

        String error = new Correct().UnCorrectLogin();

        assertEquals("[Не удалось выполнить вход. Проверьте логин/пароль]", error);
    }
}
