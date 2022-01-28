package pages;

import org.openqa.selenium.By;

public class EditProfile extends BaseMethods{

    private String EDIT_PROFILE_HEADER = "accSettingsFragmentTxtHeading";
    private String BACK_BTN_EDIT_PROFILE_SCREEN = "id=>accSettingsIvClose";

    public Boolean verifyEditProfileName(){
        sleep(3000);
        String edit_profile_header = driver.findElement(By.id(EDIT_PROFILE_HEADER)).getText();
        return edit_profile_header.contains("Edit Profile");
    }

    public void clickBackArrowEditScreen(){
        waitForElement(BACK_BTN_EDIT_PROFILE_SCREEN,3);
        elementClick(BACK_BTN_EDIT_PROFILE_SCREEN,"Back button on edit profile screen");
    }
}
