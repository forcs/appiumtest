package com.example;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author eva
 * @date 2017/6/30
 */

public class MainPage extends BasePage {


    @AndroidFindBy(id = "com.tencent.android.qqdownloader:id/awt")
    WebElement searchBox; // 搜索框
    public MainPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
