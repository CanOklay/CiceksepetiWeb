package com.ciceksepeti.test;

import com.ciceksepeti.page.LoginPage;
import static com.ciceksepeti.element.LoginPageElements.*;
import static com.ciceksepeti.constant.Constants.*;
import org.testng.annotations.Test;

/**
 * Created by Fatih Can Oklay
 * Date: 30.12.2021
 */

public class LoginTest extends LoginPage {

    @Test(testName = "Yanlış şifre ile login",
            dataProvider = "wrongPassword")
    public void loginWithWrongPassword(String correctEmail, String wrongPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithWrongPassword(wrongPassword);
        clickSigninButton();
        closePopup();
    }

    @Test(testName = "Eksik şifre ile login",
            dataProvider = "missingEmail")
    public void loginWithMissingEmail(String correctEmail, String wrongPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithMissingPassword(wrongPassword);
        clickSigninButton();
        assertEmailError(getText(EMAIL_ERROR), EMAIL_ERROR_TEXT);
    }

    @Test(testName = "Boş email ve şifre ile login")
    public void loginWithEmptyEmailAndPassword() {
        clickSigninButton();
        assertEmailError(getText(EMAIL_ERROR), ERROR_TEXT);
        assertEmailError(getText(PASSWORD_ERROR), ERROR_TEXT);
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
