package com.example;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author eva
 * @date 2017/5/18
 */

public class BasePage {

    private static final int WAIT = 1;
    private static final int LONG_WAIT = 10;

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait driverWait;
    private WebDriverWait driverLongWait;

    public BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, WAIT);
        driverWait = new WebDriverWait(driver, LONG_WAIT);
        PageFactory.initElements(this.driver, this);  // 这句非常重要，如果不写的话尽管编译不会报错，但是后面要说的页面元素在运行时一个都找不到
    }
}
