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

    public void assertMainPage() {
        assertEquals(getText(MAINPAGE), MAINPAGE_TEXT);
        logger.info("Login olundu.");
    }

    public void assertEmailError(String error, String errorText) {
        assertEquals(error, errorText);
        logger.info("Email login uyarısı kontrol edildi.");
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
}
