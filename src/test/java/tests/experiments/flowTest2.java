package tests.experiments;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class flowTest2 {

    @Test
    public void testThird() {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--diable--notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        WebElement element = driver.findElement(By.xpath("//*[@id = 'email']"));
        element.sendKeys("email id");
        WebElement element2 = driver.findElement(By.xpath("//*[@id = 'pass']"));
        element2.sendKeys("password");

        element2.submit();
    }
}
