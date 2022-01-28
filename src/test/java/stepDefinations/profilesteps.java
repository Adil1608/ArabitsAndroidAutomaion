package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CommonMethods;
import pages.Profile;
import utils.BaseTest;

public class profilesteps extends Profile {

    @Then("I should see guest name on Profile screen")
    public void i_should_navigate_on_profile_screen() {
        Boolean result = verifyUserProfileName();
        Assert.assertTrue(result);
    }

    @Then("I should navigate on the login screen")
    public void i_should_navigate_on_the_login_screen() {
        Boolean result =verifyUserProfileName();
        Assert.assertTrue(result);
    }

    @Then("I should be able to see user icon on profile screen")
    public void i_should_see_user_profile(){
        Boolean result = verifyUserIcon();
        Assert.assertTrue(result);
    }

    @When("I tap setting button on profile screen")
    public void i_tap_setting_button_on_profile_screen() {
        openProfileSettings();
    }

    @When("I tap create your account button on profile screen")
    public void i_tap_create_your_account_button_on_profile_screen() {
        tapCreateYourAccountBtn();
    }

    @When("I tap login link on profile screen")
    public void i_tap_login_link_on_profile_screen() {
        tapLoginLink();
    }

    @When("I tap on Edit button on Profile screen")
    public void i_tap_on_edit_button_on_profile_screen() {
        tapEditBtn();
    }

    @Then("I should see lock icon with {string} at the end of progress bar")
    public void i_should_see_lock_icon_with_at_the_end_of_progress_bar(String string) {
        verifyProgressBarSegmentForGuestUser(string);
    }

    @Then("I should see Level tag {string} for guest user")
    public void i_should_see_level_tag_for_guest_user(String string) {
        Assert.assertTrue(verifyLevelTagForGuestUser(string));
    }

    @Then("I should be able to see {string} on profile screen")
    public void i_should_be_able_to_see_register_now_to_save_your_xp_and_access_your_full_profile_on_profile_screen(String text) {
        Assert.assertTrue(verifyCreateAccountText(text));
    }

    @Then("I should see {string} on Profile screen")
    public void i_should_see_on_profile_screen(String string) {
        String actualText = verifyAlreadyHaveAccountText();
        Assert.assertTrue(CommonMethods.verifyTextContains(actualText,string));
    }

    @Then("I should not see lock icon And see {string} at the end of progress bar")
    public void i_should_not_see_lock_icon_and_see_at_the_end_of_progress_bar(String string) {
//        verifyProgressBarSegmentForRegisteredUser(string);
    }
}
