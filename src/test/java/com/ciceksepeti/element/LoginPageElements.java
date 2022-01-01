package com.ciceksepeti.element;

import org.openqa.selenium.By;

/**
 * Created by Fatih Can Oklay
 * Date: 30.12.2021
 */

public class LoginPageElements {

    public static final By EMAIL = By.id("EmailLogin");
    public static final By EMAIL_ERROR = By.id("EmailLogin-error");
    public static final By PASSWORD = By.id("Password");
    public static final By PASSWORD_ERROR = By.id("Password-error");
    public static final By EYE_ICON = By.cssSelector("span[class='form-group__show-type js-show-type icon-eye']");
    public static final By SIGNIN_BUTTON = By.cssSelector("button[class='btn btn-primary btn-lg pull-right login__btn js-login-button']");
    public static final By POPUP = By.cssSelector("div[class='modal-body']");
    public static final By POPUP_OK_BUTTON = By.cssSelector("button[class='btn btn-primary']");
    public static final By MAINPAGE = By.xpath("//span[@class='district-search-button__text js-district-search-button-text empty']");
    public static final By FORGOT_PASSWORD = By.cssSelector("a[class='login__forgot-password js-forgot-password']");
    public static final By FORGOT_PASSWORD_MAIL = By.id("Mail");
    public static final By FORGOT_PASSWORD_SEND = By.cssSelector("button[class='btn btn-lg btn-primary form-password-recovery__btn js-password-recovery-button']");
    public static final By FORGOT_PASSWORD_MESSAGE = By.cssSelector("div[class='password-recovery-result js-password-recovery-result is-hidden']");
    public static final By GOOGLE_LOGIN = By.cssSelector("span[class='login__social-text login__social-google-text']");
    public static final By GOOGLE_LOGIN_EMAIL = By.id("identifierId");
    public static final By GOOGLE_LOGIN_FORWARD = By.xpath("//span[@class='VfPpkd-vQzf8d'][contains(text(), 'İleri')]");
    public static final By GOOGLE_LOGIN_PASSWORD = By.cssSelector("input[type='password']");
}
