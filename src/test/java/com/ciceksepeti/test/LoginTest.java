package com.ciceksepeti.test;

import com.ciceksepeti.page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends LoginPage {

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
