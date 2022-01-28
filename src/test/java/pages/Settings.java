package pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class Settings extends BaseMethods{

    /** LOCATORS **/
    private String SETTING_TEXT = "profileSettingsTitleTV";
    private String BACK_ARROW_BTN_SETTING = "id=>profileSettingsCloseIv";

    public String verifySettingText(){
        sleep(2000);
        String settingText = driver.findElement(By.id(SETTING_TEXT)).getText();
        return settingText;
    }

    public void clickBackArrowSettingScreen(){
        waitForElement(BACK_ARROW_BTN_SETTING,3);
        elementClick(BACK_ARROW_BTN_SETTING,"Back button on setting screen");
    }
}
