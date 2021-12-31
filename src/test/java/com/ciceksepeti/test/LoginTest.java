package com.ciceksepeti.test;

import com.ciceksepeti.page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends LoginPage {

    @Test(testName = "Yanlış şifre ile login",
            dataProvider = "wrongPassword")
    public void loginWithWrongPassword(String correctEmail, String wrongPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithWrongPassword(wrongPassword);
        clickSigninButton();
        closePopup();
    }

    @Test(testName = "Başarılı login",
          dataProvider = "correctData",
          priority = 1)
    public void successfulLogin(String correctEmail, String correctPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithCorrectPassword(correctPassword);
        clickSigninButton();
        assertMainPage();
    }
}
