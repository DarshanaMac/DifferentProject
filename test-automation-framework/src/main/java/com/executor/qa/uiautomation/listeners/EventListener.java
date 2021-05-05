package com.executor.qa.uiautomation.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import io.qameta.allure.Step;

public class EventListener implements WebDriverEventListener {

    public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        String text = arg0.toString();
        stepLogger(text);
    }

    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        String text = arg0.toString();
        stepLogger(text);
    }

    public void afterNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub

        System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
    }

    public void afterNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void afterScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub


    }

    public void beforeNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void onException(Throwable arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
    }

    public void afterNavigateRefresh(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateRefresh(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    @Step("Basic logger")
    public void stepLogger(String message) {

    }

    public void beforeAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        // TODO Auto-generated method stub

    }

    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        // TODO Auto-generated method stub

    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {
        // TODO Auto-generated method stub

    }

    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub

    }

    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub
    }
}