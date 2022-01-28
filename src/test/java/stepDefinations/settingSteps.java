package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Settings;
import utils.BaseTest;

public class settingSteps extends BaseTest {

    @Then("I should redirected to Setting screen")
    public void i_should_redireted_to_setting_screen() {
        sleep(2000);
        settings = new Settings();
        String settingText = settings.verifySettingText();
        Assert.assertTrue(settingText.contains("Settings"));
    }

    @When("I tap on back arrow on SETTING screen")
    public void i_tap_on_back_arrow_on_setting_screen() {
        settings = new Settings();
        settings.clickBackArrowSettingScreen();
    }

}
