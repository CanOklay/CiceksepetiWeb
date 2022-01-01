package com.ciceksepeti.test;

import com.ciceksepeti.page.LoginPage;
import org.testng.annotations.Test;

import static com.ciceksepeti.constant.Constants.ERROR_TEXT;
import static com.ciceksepeti.element.LoginPageElements.EMAIL_ERROR;
import static com.ciceksepeti.element.LoginPageElements.PASSWORD_ERROR;

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
        assertEmailError();
    }

    @Test(testName = "Boş email ve şifre ile login")
    public void loginWithEmptyEmailAndPassword() {
        clickSigninButton();
        assertEmptyFieldError(getText(EMAIL_ERROR), ERROR_TEXT);
        assertEmptyFieldError(getText(PASSWORD_ERROR), ERROR_TEXT);
    }

    @Test(testName = "Google ile login olma",
            dataProvider = "googleLogin")
    public void loginWithGoogleAccount(String mail, String password) {
        clickLoginWithGoogle();
        fillGoogleEmailAndGoForward(mail);
        fillGooglePasswordAndGoForward(password);
        assertMainPage();
    }

    @Test(testName = "Şifremi unuttum alanı kontrolü",
            dataProvider = "forgetPassword")
    public void forgotPassword(String mail) {
        clickForgotPassword();
        fillForgotPasswordMail(mail);
        clickForgotPasswordSendButton();
        assertForgotPassword();
    }

    @Test(testName = "Başarılı login",
            dataProvider = "correctData")
    public void successfulLogin(String correctEmail, String correctPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithCorrectPassword(correctPassword);
        clickSigninButton();
        assertMainPage();
    }
}
