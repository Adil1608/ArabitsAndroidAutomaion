package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CommonMethods;
import pages.SetUp;

import static io.appium.java_client.appmanagement.ApplicationState.RUNNING_IN_FOREGROUND;

public class commonsteps extends CommonMethods {

//    public commonsteps(){
//        SetUp.initalize();
//        init();
//    }

    @Given("I launched the app")
    public void i_launched_the_app() {
        Enum app_state  = driver.queryAppState("com.alefeducation.arabits.dev");
        if (app_state == RUNNING_IN_FOREGROUND){
            driver.closeApp();
        }
        sleep(1000);
//        SetUp.initalize();
        Enum app_state2  = driver.queryAppState("com.alefeducation.arabits.dev");
        if (app_state2 != RUNNING_IN_FOREGROUND){
            driver.launchApp();
        }
        sleep(1000);
    }

    @When("I skip the On-boarding flow")
    public void i_skip_the_onboarding_flow() {
        skipOnboading();
    }

    @And("I click on the login button on Profile screen")
    public void i_click_on_the_login_button_on_profile_screen() {
       goToProfilePage();
    }

    @When("I wait for {int} seconds")
    public void i_wait_for_seconds(Integer int1) {
        sleep(int1);
    }

    @And("I close the App")
    public void i_close_app() {
        closeApp();
    }

    @When("I tap on continue with free lessons button")
    public void i_tap_on_continue_with_free_lessons_button() {
        sleep(2000);
        skipSubscriptionContinueWithFreeLessons();
    }

    @When("I tap on Profile tab")
    public void i_tap_on_profile_tab() {
        goToProfilePage();
    }

}
