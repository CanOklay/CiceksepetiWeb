package com.ciceksepeti.listener;

import com.ciceksepeti.page.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by Fatih Can Oklay
 * Date: 30.12.2021
 */

public class Listener implements ITestListener {

    BasePage basePage = new BasePage();
    Logger logger = LogManager.getLogger(Listener.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("----------TEST BAŞLIYOR----------");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        basePage.screenShot("failScreenShot");
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("----------TEST BİTTİ----------");
        ITestListener.super.onFinish(context);
    }
}
