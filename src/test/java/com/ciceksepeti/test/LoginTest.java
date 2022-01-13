package com.ciceksepeti.test;

import com.ciceksepeti.listener.RetryAnalyzer;
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

    @Test(testName = "Login with wrong password",
            dataProvider = "wrongPassword",
            retryAnalyzer = RetryAnalyzer.class)
    public void loginWithWrongPassword(String correctEmail, String wrongPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithWrongPassword(wrongPassword);
        clickSigninButton();
        closePopup();
    }

    @Test(testName = "Login with missing email",
            dataProvider = "missingEmail",
            retryAnalyzer = RetryAnalyzer.class)
    public void loginWithMissingEmail(String correctEmail, String wrongPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithMissingPassword(wrongPassword);
        clickSigninButton();
        assertEmailError();
    }

    @Test(testName = "Login with empty email and password",
            retryAnalyzer = RetryAnalyzer.class)
    public void loginWithEmptyEmailAndPassword() {
        clickSigninButton();
        assertEmptyFieldError(getText(EMAIL_ERROR), ERROR_TEXT);
        assertEmptyFieldError(getText(PASSWORD_ERROR), ERROR_TEXT);
    }

    @Test(testName = "Login with google account",
            dataProvider = "googleLogin",
            retryAnalyzer = RetryAnalyzer.class)
    public void loginWithGoogleAccount(String mail, String password) {
        clickLoginWithGoogle();
        fillGoogleEmailAndGoForward(mail);
        fillGooglePasswordAndGoForward(password);
        assertMainPage();
    }

    @Test(testName = "Check forgot password",
            dataProvider = "forgetPassword",
            retryAnalyzer = RetryAnalyzer.class)
    public void forgotPassword(String mail) {
        clickForgotPassword();
        fillForgotPasswordMail(mail);
        clickForgotPasswordSendButton();
        assertForgotPassword();
    }

    @Test(testName = "Successful login",
            dataProvider = "correctData",
            retryAnalyzer = RetryAnalyzer.class)
    public void successfulLogin(String correctEmail, String correctPassword) {
        fillWithCorrectEmail(correctEmail);
        fillWithCorrectPassword(correctPassword);
        clickSigninButton();
        assertMainPage();
    }
}
