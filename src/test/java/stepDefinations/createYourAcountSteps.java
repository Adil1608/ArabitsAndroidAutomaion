package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateYourAccount;
import utils.BaseTest;

public class createYourAcountSteps extends BaseTest {
    @Then("I should redirected to Create your account screen")
    public void i_should_redireted_to_create_your_account_screen() {
        createAccount = new CreateYourAccount();
        String createAccountText = createAccount.verifyCreateAccountText();
        Assert.assertTrue(createAccountText.contains("Create your account"));
    }
    @When("I tap on back arrow on Create your account screen")
    public void i_tap_on_back_arrow_on_create_your_account_screen() {
        createAccount.tapBackArrow();
    }
}
