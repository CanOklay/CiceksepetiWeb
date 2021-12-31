package com.ciceksepeti.page;
import org.testng.annotations.DataProvider;

import static com.ciceksepeti.element.LoginPageElements.*;
import static com.ciceksepeti.constant.Constants.*;

/**
 * Created by Fatih Can Oklay
 * Date: 30.12.2021
 */

public class LoginPage extends BasePage{

    public void fillWithCorrectEmail(String mail) {
        try {
            clear(EMAIL);
            sendKeys(EMAIL, mail);
            logger.info("Doğru kullanıcı adı girildi");
            assertTrue(true, "Email adresinin yazıldığı kontrol edildi.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Email adresi girilemedi!");
            assertFail();
        }
    }

    public void fillWithCorrectPassword(String password) {
        try {
            clear(PASSWORD);
            sendKeys(PASSWORD, password);
            logger.info("Doğru şifre girildi");
            clickElement(EYE_ICON);
            logger.info("Şifreyi gösterme ikonuna tıklandı.");
            assertTrue(true, "Şifrenin yazıldığı kontrol edildi.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Şifre girilemedi!");
            assertFail();
        }
    }

    public void fillWithWrongPassword(String password) {
        try {
            clear(PASSWORD);
            sendKeys(PASSWORD, password);
            logger.info("Yanlış şifre girildi");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Şifre girilemedi!");
            assertFail();
        }
    }

    public void fillWithMissingPassword(String password) {
        try {
            clear(PASSWORD);
            sendKeys(PASSWORD, password);
            logger.info("Eksik şifre girildi");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Şifre girilemedi!");
            assertFail();
        }
    }

    public void clickSigninButton() {
        try {
            clickElement(SIGNIN_BUTTON);
            logger.info("Sign in butonuna tıklandı.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Login olunamadı!");
            assertFail();
        }
    }

    public void closePopup() {
        try {
            assertEquals(getText(POPUP), POPUP_TEXT);
            logger.info("Popup text'i kontrol edildi.");
            clickElement(POPUP_OK_BUTTON);
            logger.info("Popup'daki ok butonuna tıklandı.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Popup kapatılamadı!");
            assertFail();
        }
    }

    public void clickForgotPassword() {
        try {
            clickElement(FORGOT_PASSWORD);
            logger.info("Şifremi unuttum yazısına tıklandı.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Şifremi unuttum yazısına tıklanamadı!");
            assertFail();
        }
    }

    public void fillForgotPasswordMail(String mail) {
        try {
            clear(FORGOT_PASSWORD_MAIL);
            sendKeys(FORGOT_PASSWORD_MAIL, mail);
            logger.info("Doğru mail adresi girildi");
            assertTrue(true, "Email adresinin yazıldığı kontrol edildi.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Email adresi girilemedi!");
            assertFail();
        }
    }

    public void clickForgotPasswordSendButton() {
        try {
            clickElement(FORGOT_PASSWORD_SEND);
            logger.info("Gönder butonuna tıklandı.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Gönder butonuna tıklanamadı!");
            assertFail();
        }
    }

    public void clickLoginWithGoogle() {
        try {
            clickElement(GOOGLE_LOGIN);
            logger.info("Google ile login olma butonuna tıklandı.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Google ile login olma butonuna tıklanamadı!");
            assertFail();
        }
    }

    public void fillGoogleEmailAndGoForward(String email) {
        try {
            sendKeys(GOOGLE_LOGIN_EMAIL, email);
            logger.info("Google ile login olmada email girilir.");
            clickElement(GOOGLE_LOGIN_FORWARD);
            logger.info("İleri butonuna tıklandı.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Google ile login olmada email girilemedi.!");
            assertFail();
        }
    }

    public void fillGooglePasswordAndGoForward(String password) {
        try {
            sendKeys(GOOGLE_LOGIN_PASSWORD, password);
            logger.info("Google ile login olmada email girilir.");
            clickElement(GOOGLE_LOGIN_FORWARD);
            logger.info("İleri butonuna tıklandı.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Google ile login olmada email girilemedi.!");
            assertFail();
        }
    }

    public void assertMainPage() {
        assertEquals(getText(MAINPAGE), MAINPAGE_TEXT);
        logger.info("Login olundu.");
    }

    public void assertEmailError(String error, String errorText) {
        assertEquals(error, errorText);
        logger.info("Email login uyarısı kontrol edildi.");
    }

    public void assertForgotPassword(String message, String messageText) {
        assertEquals(message, messageText);
        logger.info("Forgot password mail mesajı kontrol edildi.");
    }

    @DataProvider
    public Object[][] correctData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "ciceksepetitest0@gmail.com";
        data[0][1] = "Ciceksepetitest0.";
        return data;
    }

    @DataProvider
    public Object[][] wrongPassword() {
        Object[][] data = new Object[1][2];
        data[0][0] = "ciceksepetitest0@gmail.com";
        data[0][1] = "Ciceksepetitest0";
        return data;
    }

    @DataProvider
    public Object[][] missingEmail() {
        Object[][] data = new Object[1][2];
        data[0][0] = "ciceksepetitest0";
        data[0][1] = "Ciceksepetitest0.";
        return data;
    }

    @DataProvider
    public Object[][] forgetPassword() {
        Object[][] data = new Object[1][1];
        data[0][0] = "ciceksepetitest0@gmail.com";
        return data;
    }

    @DataProvider
    public Object[][] googleLogin() {
        Object[][] data = new Object[1][2];
        data[0][0] = "ciceksepetitest0@gmail.com";
        data[0][1] = "CicekSepetiTest09.!";
        return data;
    }
}
