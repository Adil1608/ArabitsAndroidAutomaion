package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class SetUp {
    public static AndroidDriver driver; // public WebDriver driver
    public static WebDriverWait wait;

    public SetUp() {}

    public static void initalize() {

        if(driver!= null){
            return;
        }

        // Capabilities Setup
        File appDir = new File("src/Application");
        File app = new File(appDir, "Arabits.apk");

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 3a");
        dc.setCapability("platformName", "Android");
        dc.setCapability("app", app.getAbsolutePath());
        // dc.setCapability("appPackage", "com.alefeducation.arabits"); // for qa builds
        dc.setCapability("appPackage", "com.alefeducation.arabits.dev"); // for dev builds
        dc.setCapability("appActivity", "com.alefeducation.arabits.base.SplashScreenActivity"); // activity is the same for dev and qa builds
        dc.setCapability("noReset", "false");
        dc.setCapability("fullReset", "false");

        // Driver Setup
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
            wait = new WebDriverWait(driver, 60);

            Dimension windowSize = driver.manage().window().getSize();
            System.out.println("windowSize:");
            System.out.println(windowSize);
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }
    }


}
