package utils;

import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.*;
import pages.*;

public class BaseTest extends BaseMethods{

    protected CommonMethods commonMethods ;
    protected Profile profile;
    protected Login login;
    protected Settings settings;
    protected CreateYourAccount createAccount ;
    protected EditProfile editprofile ;


    @BeforeClass
    @Parameters({"browser"})
    public void commonSetUp(@Optional("IamOptional") String browser) {

    }

    @BeforeMethod
    public void beforeMethod() {
    }



    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.queryAppState("com.alefeducation.arabits.dev"));
        driver.closeApp();
//        driver.queryAppState("com.alefeducation.arabits.dev");

    }

    @AfterClass
    public void commonTearDown() {

    }
}
