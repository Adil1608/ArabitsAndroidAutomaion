package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.SetUp;

public class Hooks extends SetUp{

    @Before
    public void beforeScenario(){
//        SetUp.initalize();
//        System.out.println("This will run before the Scenario");
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
//        System.out.println(driver.queryAppState("com.alefeducation.arabits.dev"));
//        driver.closeApp();
    }
}
