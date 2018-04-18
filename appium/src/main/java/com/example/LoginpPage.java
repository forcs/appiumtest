package com.example;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author eva
 * @date 2017/5/18
 */

public class LoginpPage extends BasePage {

    @FindBy()
    private AndroidElement aa;

    public LoginpPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
