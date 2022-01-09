package com.ciceksepeti.test;

import com.ciceksepeti.config.ConfigFileReader;
import com.ciceksepeti.utility.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Created by Fatih Can Oklay
 * Date: 30.12.2021
 */

public abstract class BaseTest extends DriverFactory {

    ConfigFileReader configFileReader = new ConfigFileReader();

    @BeforeMethod
    public void setup() throws MalformedURLException {
        if (configFileReader.getEnv().equals("local")) {
            if (configFileReader.getBrowser().equals("opera")) {
                operaDriver();
            } else if (configFileReader.getBrowser().equalsIgnoreCase("firefox")) {
                firefoxDriver();
            } else {
                chromeDriver();
            }
        } else {
            remoteWebDriver();
        }
        driver.navigate().to(configFileReader.getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicityWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageLoadTimeout()));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configFileReader.getWebDriverWait()));
    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
