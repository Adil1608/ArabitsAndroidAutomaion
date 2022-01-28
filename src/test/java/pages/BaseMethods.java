package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BaseMethods extends SetUp {
    WebDriverWait wait;
    public AndroidDriver driver;

    public BaseMethods(){
        SetUp.initalize();
        init();
    }

    public void init(){
        wait=SetUp.wait;
        this.driver = SetUp.driver;
    }

    public void scroll(double x1, double y1, double x2, double y2){
        Dimension size	=driver.manage().window().getSize();
        int height=size.height;
        int width=size.width;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height * y2); // height*.7
        int endYCoordinate= (int)(height * y1); // height*.2

        TouchAction act = new TouchAction(driver);
        act.press(PointOption.point(middleOfX, startYCoordinate))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }

    public void scroll_up(){
        this.scroll(0.4, 0.4,0.4,0.9);
    }

    public void scroll_down(){
        this.scroll(0.5, 0.2,0.5,0.7);
    }

    public WebElement explicit_wait_for_element(String locator, String... locator_type) {
        if(!locator.contains("@resource-id")){
            locator = "//*[@resource-id=\"" + locator + "\"]";
        }
        WebElement element;
        element = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        return element;
    }

    public void explicit_wait_for_element_click(String locator) {
        //todo change:
        if(!locator.contains("@resource-id")){
            locator = "//*[@resource-id=\"" + locator + "\"]";
        }
        this.explicit_wait_for_element(locator);
        WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        element.click();
    }

    public boolean explicit_wait_check_element_displayed(String locator){
        return this.explicit_wait_for_element(locator).isDisplayed();
    }

    public String explicit_wait_for_element_get_text(String locator) {
        return this.explicit_wait_for_element(locator).getText();
    }
    public String explicit_wait_for_element_send_keys(String locator, String value) {
        this.explicit_wait_for_element(locator).sendKeys(value);
        return value;
    }

    public WebElement explicit_wait_get_element_by_given_text(String locator, String elementText){
        //todo change:
        if(!locator.contains("@resource-id")){
            locator = "//*[@resource-id=\"" + locator + "\"]";
        }

        List<WebElement> elements =  this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        boolean isFound = false;
        WebElement element = null;

        for (WebElement elem : elements) {
            if(elem.getText().contains(elementText)){
                isFound = true;
                element = elem;
                break;
            }
        }
        if (isFound){
            return element;
        } else {
            return null;
        }
    }

    public void explicit_wait_get_element_by_given_text_click(String locator, String elementText){
        this.explicit_wait_get_element_by_given_text(locator, elementText).click();
    }

    public void explicit_wait_element_to_be_enabled_click(String xpath) throws InterruptedException {
        this.explicit_wait_for_element(xpath);

        int time = 0;
        int interval = 200;
        while (time <= 5000){
            Boolean elementState = driver.findElement(By.xpath(xpath)).isEnabled();
            System.out.println(time + ".elementState: " + elementState);
            if (!elementState){
                time = time + interval;
                Thread.sleep(interval);
            } else {
                break;
            }
        }
    }

    /** scroll experiments*/
    public void scroll(){
        Dimension size	=driver.manage().window().getSize();
        int height=size.height;
        int width=size.width;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height*.3);
        int endYCoordinate= (int)(height*.1);

        TouchAction act = new TouchAction(driver);
        act.press(PointOption.point(middleOfX, startYCoordinate))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    /***
     * Sleep for specified number of milliseconds
     * @param msec
     * @param info
     */
    public static void sleep(long msec, String info) {
        if (info != null) {
            System.out.println("Waiting " + (msec * .001) + " seconds :: " + info);
        }
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * Sleep for specified number of milliseconds
     * @param msec
     */
    public static void sleep(long msec) {
        sleep(msec, null);
    }

    public By getByType(String locator) {
        By by = null;
        String locatorType = locator.split("=>")[0];
        locator = locator.split("=>")[1];
        try {
            if (locatorType.contains("id")) {
                by = By.id(locator);
            } else if (locatorType.contains("name")) {
                by = By.name(locator);
            } else if (locatorType.contains("xpath")) {
                by = By.xpath(locator);
            } else {
                System.out.println("Locator type not supported");
            }
        } catch (Exception e) {
            System.out.println("By type not found with: " + locatorType);
        }
        return by;
    }

    public MobileElement getElement(String locator, String info) {
        MobileElement element = null;
        By byType = getByType(locator);
        try {
            element = (MobileElement) driver.findElement(byType);
        } catch (Exception e) {
            System.out.println("Element not found with: " + locator);
            e.printStackTrace();
        }
        return element;
    }

    public void elementClick(MobileElement element, String info, long timeToWait) {
        try {
            element.click();
            if (timeToWait == 0) {
                System.out.println("Clicked On :: " + info);
            } else {
                sleep(timeToWait, "Clicked on :: " + info);
            }
        } catch (Exception e) {
            System.out.println("Cannot click on :: " + info);
//            takeScreenshot("Click ERROR", "");
        }
    }

    public void elementClick(String locator, String info) {
        MobileElement element = getElement(locator, info);
        elementClick(element, info, 0);
    }

    public MobileElement waitForElement(String locator, int timeout) {
        By byType = getByType(locator);
        MobileElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS) ;
            System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait (driver, timeout);
            element = (MobileElement) wait.until(
                    ExpectedConditions.visibilityOfElementLocated(byType));
            System.out.println("Element appeared on the screen");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS) ;
        } catch (Exception e) {
            System.out.println("Element not appeared on the screen");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS) ;
        }
        return element;
    }

    public void closeApp(){
//        driver.resetApp();
//        System.out.println(driver.queryAppState("com.alefeducation.arabits.dev"));
        driver.closeApp();
    }

    /**
     * Checks whether actual String contains expected string and prints both in log
     * @param actualText - actual Text picked up from application under Test
     * @param expText - expected Text to be checked with actual text
     * @return boolean result
     */
    public static boolean verifyTextContains(String actualText, String expText) {
        if (actualText.toLowerCase().contains(expText.toLowerCase())) {
            System.out.println("Actual Text From Application UI   --> : " + actualText);
            System.out.println("Expected Text From Application UI --> : " + expText);
            System.out.println("### Verification Contains !!!");
            return true;
        } else {
            System.out.println("Actual Text From Application UI   --> : " + actualText);
            System.out.println("Expected Text From Application UI --> : " + expText);
            System.out.println("### Verification DOES NOT Contains !!!");
            return false;
        }
    }

    /***
     * Send Keys to element
     * @param element - Element to send data
     * @param data - Data to send
     * @param clear - True if you want to clear the field before sending data
     */
    public void sendData(MobileElement element, String data, Boolean clear) {
        try {
            if (clear) {
                element.clear();
            }
            element.sendKeys(data);
            System.out.println("Send Keys on element with data :: " + data);
        } catch (Exception e) {
            System.out.println("Send Keys on element with data :: " + data);
        }
    }

    /***
     * Send Keys to element with locator and clear
     * @param locator - locator
     * @param data - Data to send
     */
    public void sendData(String locator, String data) {
        MobileElement element = getElement(locator,"");
        sendData(element, data, true);
    }
}