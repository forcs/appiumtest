package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author eva
 * @date 2017/3/31
 */

public class AndroidContactTest {
    //Driver
    private AppiumDriver<AndroidElement> driver;

    private static final String PACKAGE_NAME = "cmb.pb";


    /**
     * 配置启动driver
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

//        File classpathRoot = new File(System.getProperty("user.dir"));
//        //app的目录
//        File appDir = new File(classpathRoot, "/src/main/java/apps/");
//        //app的名字，对应你apps目录下的文件
//        File app = new File(appDir, "ContactManager.apk");
//        //创建Capabilities
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        //设置要调试的模拟器的名字
//        capabilities.setCapability("deviceName","minote");
//        //设置模拟器的系统版本
//        capabilities.setCapability("platformVersion", "4.4.2");
//        //设置app的路径
//        capabilities.setCapability("app", app.getAbsolutePath());
//        //设置app的包名
//        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
//        //设置app的启动activity
//        capabilities.setCapability("appActivity", ".ContactManager");
//        //启动driver
//        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


//        File app;
//        String apkPath = "";
//        List<String> adbPath = CmdUtil.getInstance().execCmd("adb shell pm path " + PACKAGE_NAME);
//        if (adbPath != null && adbPath.size() > 0) {
//            apkPath = adbPath.get(0).replace("package:", "");
//        }
//
//        if (apkPath.equals("")) {
//
//        } else {
//            app = new File(apkPath);
//        }

//        File classpathRoot = new File(System.getProperty("user.dir"));
//        //app的目录
//        File appDir = new File(classpathRoot, "/src/main/java/apps/");
//        //app的名字，对应你apps目录下的文件
//        File app = new File(appDir, "CMBMobileBank.apk");

//        File app = new File(appDir, "haofangtuo-dev-debug.apk");
        //创建Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //设置要调试的模拟器的名字
//        capabilities.setCapability("deviceName","69T7N15A13009997");
//        capabilities.setCapability("deviceName","d61775e2");

        capabilities.setCapability("deviceName", "5LM7N16314000916");

        //设置模拟器的系统版本
//        capabilities.setCapability("platformVersion", "6.0.1 MXB48T");
        capabilities.setCapability("platformVersion", "6.0");

        //设置app的路径
//        capabilities.setCapability("app", app.getAbsolutePath());
        //设置app的包名
        capabilities.setCapability("appPackage", PACKAGE_NAME);
//        capabilities.setCapability("appPackage", "com.pinganfang.haofangtuo");
        //设置app的启动activity
        capabilities.setCapability("appActivity", ".ui.PBInitActivity");
        // 不需要再次安装
        capabilities.setCapability("noReset", true);
        // 中文支持
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        //启动driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        // 重置
        CmdUtil.getInstance().execCmd("adb shell am force-stop " + PACKAGE_NAME);
        CmdUtil.getInstance().execCmd("adb shell pm clear " + PACKAGE_NAME);
        CmdUtil.getInstance().execCmd("adb shell rm -r /storage/emulated/0/cmb");
        //测试完毕，关闭driver，不关闭将会导致会话还存在，下次启动就会报错
        driver.quit();
    }

//    @Test
    public void testHaofangtuo() {
        AndroidElement mine = null;
        while (mine == null) {
            try {
                mine = driver.findElementById("com.pinganfang.haofangtuo:id/tab_4");
            } catch (NoSuchElementException e) {

            }
        }
        mine.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4 * 3, width / 2, height / 4, 1000);
        driver.findElementById("com.pinganfang.haofangtuo:id/questions_answers_ll").click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String context : driver.getContextHandles()) {
            if (context.toLowerCase().startsWith("webview")) {
                driver.context(context);
                break;
            }
        }
        driver.findElementByXPath("//android.view.View[contains(@content-desc,'注册登录/认证')]").click();

//        driver.tap(1, 283, 592, 100);
    }


    /**
     * 要执行的的测试方法
     */
    @Test
    public void addContact(){

        if (isReachActivity(".ui.WhatsNewActivity")) {
            driver.swipe(937, 878, 937, 104, 100);
            sleep(1000);

            driver.swipe(937, 878, 937, 104, 100);
            sleep(1000);

            driver.swipe(937, 878, 937, 104, 100);
            sleep(1000);

            driver.tap(1, 553, 1581, 100);
            sleep(5000);
        }

        // Loading页面点击跳过
//        AndroidElement skip = null;
//        while (skip == null) {
//            try {
//                skip = driver.findElementById("cmb.pb:id/cpvSkip");
//            } catch (NoSuchElementException e) {
//
//            }
//        }
//        skip.click();

        while (!isReachActivity(".ui.PBEntryActivity")) {
            sleep(1000);
        }
        driver.findElementById("cmb.pb:id/toptoolssearchbar").click();

        while (!isReachActivity(".ui.PBSearchActivity")) {
            sleep(1000);
        }
        driver.findElementById("cmb.pb:id/filter_edit").sendKeys("房产估值");
        driver.findElementById("cmb.pb:id/btnCancel").click();

        sleep(5000);
        driver.tap(1, 800, 445, 100);

        sleep(3000);
        driver.tap(1, 585, 1588, 100);

        sleep(5 * 1000);
        AndroidElement ssl = driver.findElementById("cmb.pb:id/buttonPositive");
        if (ssl != null) {
            ssl.click();
        }
        sleep(10 * 1000);


//        for (String context : driver.getContextHandles()) {
//            if (context.toLowerCase().startsWith("webview")) {
//                driver.context(context);
//                break;
//            }
//        }
//
//        driver.findElementByXPath("//android.view.View[contains(@content-desc,'房产估值')]").click();

//        //利用Xpath的方法寻找text值为Add Contact的控件
//        WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));
//        //点击这个控件
//        el.click();
//        //利用类名获取界面上所有的EditText
//        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
//        //第一个EditText输入内容Some Name
//        textFieldsList.get(0).sendKeys("Some Name");
//        //第三个EditText输入内容Some Name
//        textFieldsList.get(2).sendKeys("Some@example.com");
//        //在坐(100,500)滑动到(100,100) 时间为2毫秒
//        driver.swipe(100, 500, 100, 100, 2);
//        //用xpath的方式寻找到text值为Save的控件，然后点击
//        driver.findElementByXPath(".//*[@text='Save']").click();
    }

    private boolean isReachActivity(String name) {
        if (!((AndroidDriver) driver).currentActivity().equals(name)) {
            return false;
        }
        return true;
    }

    private void sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
