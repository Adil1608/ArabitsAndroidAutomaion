package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CommonMethods;
import pages.Login;

public class loginsteps extends Login {

    @Then("I should be redirected to Login screen")
    public void i_should_be_redirected_to_login_screen() {
        String loginPageText = verifyLoginPage();
        Assert.assertTrue(CommonMethods.verifyTextContains(loginPageText,"Log in to continue"));
    }

    @When("I tap on back arrow on Login screen")
    public void i_tap_on_back_arrow_on_login_screen() {
        tapBackArrow();
    }

    @When("I enter {string} and {string} on login screen")
    public void i_enter_and_on_login_screen(String string, String string2) {
        loginIntoApplication(string,string2);
    }
    @When("I tap on LOGIN button on login screen")
    public void i_tap_on_login_button_on_login_screen() {
       clickLoginBtn();
       sleep(2000);
    }
}
