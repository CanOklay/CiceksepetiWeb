package com.ciceksepeti.element;

import org.openqa.selenium.By;

public class LoginPageElements {

    public static final By EMAIL = By.id("EmailLogin");
    public static final By EMAIL_ERROR = By.id("EmailLogin-error");
    public static final By PASSWORD = By.id("Password");
    public static final By PASSWORD_ERROR = By.id("Password-error");
    public static final By EYE_ICON = By.cssSelector("span[class='form-group__show-type js-show-type icon-eye']");
    public static final By SIGNIN_BUTTON = By.cssSelector("button[class='btn btn-primary btn-lg pull-right login__btn js-login-button']");
    public static final By MAINPAGE = By.xpath("//span[@class='district-search-button__text js-district-search-button-text empty']");
}
