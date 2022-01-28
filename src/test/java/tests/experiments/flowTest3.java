package tests.experiments;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class flowTest3 {

//    public static void main(String []args) throws MalformedURLException{}

    @Test
    public void testThird() {
        // Capabilities Setup
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("deviceName","Pixel3");
        dc.setCapability("platformName","Android");
        dc.setCapability("appPackage","com.android.chrome");
        dc.setCapability("appActivity","com.google.android.apps.chrome.Main");
        dc.setCapability("noReset","true");

        // Driver Setup
        try {
            WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
//            driver.findElement(By.id("com.android.chrome:id/url_bar")).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);

//            System.out.println(urlBar);
//            WebElement urlBar = driver.findElement(By.id("com.android.chrome:id/url_bar"));
            WebElement urlBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.chrome:id/url_bar")));
            urlBar.click();
            urlBar.sendKeys("ABCDEFG");
            urlBar.sendKeys(Keys.ENTER);

        }catch(MalformedURLException ex){
            //do exception handling here
        }

//




        // TODO Auto-generated method stub
//        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--diable--notifications");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("https://www.facebook.com");
//        WebElement element = driver.findElement(By.xpath("//*[@id = 'email']"));
//        element.sendKeys("email id");
//        WebElement element2 = driver.findElement(By.xpath("//*[@id = 'pass']"));
//        element2.sendKeys("password");
//
//        element2.submit();
    }
}
