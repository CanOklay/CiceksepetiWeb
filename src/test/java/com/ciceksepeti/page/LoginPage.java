package com.ciceksepeti.page;
import org.testng.annotations.DataProvider;

import static com.ciceksepeti.element.LoginPageElements.*;
import static com.ciceksepeti.constant.Constants.*;

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

    public void assertMainPage() {
        assertEquals(getText(MAINPAGE), MAINPAGE_TEXT);
        logger.info("Login olundu.");
    }

    @DataProvider
    public Object[][] correctData() {
        Object[][] data = new Object[1][2];
        data[0][0] = "ciceksepetitest0@gmail.com";
        data[0][1] = "Ciceksepetitest0.";
        return data;
    }
}
