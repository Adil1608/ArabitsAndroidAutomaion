package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.EditProfile;
import utils.BaseTest;

public class EditProfileSteps extends BaseTest {

    @Then("I should be navigated to Edit Profile screen")
    public void i_should_be_navigated_to_edit_profile_screen() {
        editprofile = new EditProfile();
        Boolean status = editprofile.verifyEditProfileName();
        Assert.assertTrue(status);
    }

    @When("I tap on back arrow on EDIT PROFILE screen")
    public void i_click_Back_edit_profile_screen() {
        editprofile = new EditProfile();
        editprofile.clickBackArrowEditScreen();
    }
}
