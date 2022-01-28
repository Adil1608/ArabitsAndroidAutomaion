package pages;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.EmailReader;
import utils.DataGenerator;


public class Profile extends BaseMethods{

    private String PROFILE_NAME = "profileFragmentNameTV";
    private String LOGIN_LINK = "profileFragmentGuestUserLoginTextSubText";
    private String CREATE_ACCOUNT_LINK = "id=>profileFragmentGuestUserCompleteAccountButton";
    private String USER_ICON = "userProfile";
    private String PROFILE_EDIT_BTN = "profileEdit";
    private String PROGRESS_BAR = "profileFragmentProgressBar";
    private String PROGRESS_BAR_LOCK_ICON = "itemSegmentLockImage";
    private String PROGRESS_BAR_LOCK_TEXT = "itemSegmentProgressText";
    private String PROGRESS_BAR_COUNT = "itemSegmentMasteryCurrentUntilTarget";
    private String LEVELTAG_GUESTUSER = "profileFragmentMasteryLevelBtn";
    private String CREATEACCOUNT_TEXT_PROFILE_SCREEN = "id=>profileFragmentGuestUserPromptText";
    private String ALREADY_HAVE_ACCOUNT_TEXT = "id=>profileFragmentGuestUserLoginText";

    public void openProfileSettings(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"profileFragmentSettingsBtn\")]");
    }
    public void openAccountSettings(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"profileEdit\")]");
    }
    public void openSubscriptionSection(){
        String xpath = "//*[contains(@resource-id,\"profileSettingsMenuItemSubscription\")]";
        explicit_wait_for_element_click(xpath);
    }
    public void clickLogIn(){
        String xpath = "//*[contains(@resource-id,\"profileFragmentGuestUserLoginTextSubText\")]";
        explicit_wait_for_element_click(xpath);
    }
    public void clickLogout(){
        String xpath = "//*[contains(@resource-id,\"MenuItemLogout\")]";
        explicit_wait_for_element_click(xpath);
    }
    public void clickConfirmLogout(){
        // id in case of reg user: "com.alefeducation.arabits:id/customDialogPositiveBtn"
        String xpath = "//*[contains(@resource-id,\"guestLogOutContinueBTN\") or contains(@resource-id,\"customDialogPositiveBtn\")]";
        explicit_wait_for_element_click(xpath);
    }

    /** Account Settings sub-section **/
    public String getUsernameFiledValue(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtUsername";
        return explicit_wait_for_element_get_text(xpath);
    }
    public String getNameFiledValue(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtStudentName";
        return explicit_wait_for_element_get_text(xpath);
    }
    public String getEmaiFieldlValue(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtStudentEmail";
        String email_value = explicit_wait_for_element_get_text(xpath);
        System.out.print("\nEmail: " + email_value + "\n");
        return email_value;
    }
    public void getAvatarImage(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtProfileImage";
        explicit_wait_for_element(xpath);
    }

    // Account edit mode
    public void clickEditButton(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtEdit";
        explicit_wait_for_element_click(xpath);
    }
    public void clickRefreshUsernameButton(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtUsernameRefresh";
        explicit_wait_for_element_click(xpath);

    }
    public String enterNameReturnValue(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtStudentName";
        String name = "TestUser" + DataGenerator.randomNumber(); //todo replace with faker name
        explicit_wait_for_element_send_keys(xpath, name);
        return this.getNameFiledValue();
    }
    public String enterUniqueEmailReturnValue(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtStudentEmail";
        String email =  DataGenerator.randomEmail();
        explicit_wait_for_element_send_keys(xpath, email);
        return email;
    }
    public void clickOnFreeSpaceOnScreen(){
        // makes tool tip disappear
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtHeading";
        explicit_wait_for_element_click(xpath);
    }
    public void clickSaveButton(){
        String xpath = "com.alefeducation.arabits.dev:id/accSettingsFragmentTxtEdit";
        explicit_wait_for_element_click(xpath);
    }

    // Profile creation Page
    public void enterRegistrationPasswd(){
        String xpath = "com.alefeducation.arabits.dev:id/accountInfoFragmentEditTextPassword";
        String password = "Arbits108"; // todo config
        explicit_wait_for_element_send_keys(xpath,password);
    }
    public void enterRegistrationConfirmationPasswd(){
        String xpath = "com.alefeducation.arabits.dev:id/accountInfoFragmentEditTextConfirmPassword";
        String password = "Arbits108"; // todo config
        explicit_wait_for_element_send_keys(xpath,password);
    }
    public void clickAgreeTermsCheckbox(){
        String xpath = "com.alefeducation.arabits.dev:id/accountInfoFragmentCheckBox";
        explicit_wait_for_element_click(xpath);
    }

    public void clickAgreePrivacyCheckbox(){
        String xpath = "com.alefeducation.arabits.dev:id/accountInfoFragmentPrivacyPolicyCB";
        explicit_wait_for_element_click(xpath);
    }
    public void clickCreateAccountButton(){
        String xpath = "com.alefeducation.arabits.dev:id/accountInfoBtnContinue";
        explicit_wait_for_element_click(xpath);
    }
    public void enterVerificationCode() throws InterruptedException {
        // Todo: instead of hard wait, wait explicitly
        Thread.sleep(4000);
        String verificationCode = EmailReader.getVerificationCode();
        String xpath = "com.alefeducation.arabits.dev:id/verifyEmailFragmentEditTextCode";
        explicit_wait_for_element_send_keys(xpath, verificationCode);
    }
    public void clickConfirmButton(){
        String xpath = "com.alefeducation.arabits.dev:id/verifyEmailFragmentBtnConfirm";
        explicit_wait_for_element_click(xpath);
    }
    public boolean isCongratsMessageDisplayed(){
        String xpath = "com.alefeducation.arabits.dev:id/congratsActivityTxtMsgAllRight";
        return explicit_wait_check_element_displayed(xpath);
    }
    public void clickCongratsActivityDoneButton(){
        String xpath = "com.alefeducation.arabits.dev:id/congratsActivityBtnDone";
        explicit_wait_for_element_click(xpath);
    }
    public void clickChangeAvatarPencil(){
        String xpath = "com.alefeducation.arabits.dev:id/icEdit";
        explicit_wait_for_element_click(xpath);
    }
    public void clickOnLockedPremiumAvatar(){
        // (Note: for premium avatars has sibling elem "id/crossover")
        String premiumAvatarsXpath = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/image\"][../*[contains(@resource-id,\"crossover\")]]";
        explicit_wait_for_element_click(premiumAvatarsXpath);
    }
    public void selectFromAvailableAvatars(){
        String availableAvatarsXpath = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/image\"][not( ../*[contains(@resource-id,\"crossover\")] )]";
        explicit_wait_for_element_click(availableAvatarsXpath);
    }
    public void clickOnUnlockedPremiumAvatar(){
        //String availableAvatarsXpath_ = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/image\"][../*[contains(@resource-id,\"icMedal\")]]";
        String availableAvatarsXpath_ = "//*[contains(@resource-id,\"image\")][../*[contains(@resource-id,\"icMedal\")]]";
        explicit_wait_for_element_click(availableAvatarsXpath_);
    }

    /** Subscription sub-section*/
    public String getNoActiveSubscriptionMsg(){
        String xpath = "com.alefeducation.arabits.dev:id/purchaseFragmentActiveTextViewNoSubscriptionBanner";
        return explicit_wait_for_element_get_text(xpath);
    }
    public void enterAccessCode(){
        String xpath = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/purchaseFragmentAccessCodeEv\"]";
        MobileElement elem = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        elem.click();
        elem.sendKeys("amaltest2");
        // TODO add keyboard enter method here
    }
    public String validateSubscriptionReturnMsg(){
        // checks if expiry information is available
        String xpath1 = "com.alefeducation.arabits.dev:id/purchaseInfoItemSubTextViewDate2";
        explicit_wait_for_element(xpath1);

        // returns "1 year subscription" subscription message
        String xpath2 = "com.alefeducation.arabits.dev:id/purchaseInfoItemTitleTextViewSubscriptionType";
        return explicit_wait_for_element_get_text(xpath2);
    }

    public Boolean verifyUserProfileName(){
//        String username = driver.findElement(By.id("profileFragmentNameTV")).getText();
        String username = driver.findElement(By.id(PROFILE_NAME)).getText();
        return username.startsWith("Guest");
    }

    public Boolean verifyUserIcon(){
        Boolean result = driver.findElement(By.id(USER_ICON)).isDisplayed();
        return result;
    }

    public void tapLoginLink(){
        driver.findElement(By.id(LOGIN_LINK)).click();
    }

    public void tapCreateYourAccountBtn(){
        sleep(3000);
        waitForElement(CREATE_ACCOUNT_LINK,3);
//        driver.findElement(By.id(CREATE_ACCOUNT_LINK)).click();
        elementClick(CREATE_ACCOUNT_LINK,"Create acount link");
    }

    public void tapEditBtn(){
        sleep(2000);
        driver.findElement(By.id(PROFILE_EDIT_BTN)).click();
    }

    public Boolean verifyProgressBarSegmentForGuestUser(String count){
        Boolean verifyProgressBar = driver.findElement(By.id(PROGRESS_BAR)).isDisplayed();
        Boolean verifyProgressBarLockIcon = driver.findElement(By.id(PROGRESS_BAR_LOCK_ICON)).isDisplayed();
        String progress_bar_lock_text = driver.findElement(By.id(PROGRESS_BAR_LOCK_TEXT)).getText();
        Boolean verify_pb_lock_text = progress_bar_lock_text.contains("Progress Locked");
        String progress_bar_count = driver.findElement(By.id(PROGRESS_BAR_COUNT)).getText();
        Boolean verify_pb_count = progress_bar_count.contains(count);
        return verifyProgressBar && verifyProgressBarLockIcon && verify_pb_lock_text && verify_pb_count;
    }

    public Boolean verifyLevelTagForGuestUser(String leveltag) {
    String verifyleveltagtext = driver.findElement(By.id(LEVELTAG_GUESTUSER)).getText();
    return verifyleveltagtext.contains(leveltag);
    }

    public Boolean verifyCreateAccountText(String expectedText){
        String Actualtext = getElement(CREATEACCOUNT_TEXT_PROFILE_SCREEN,"create account text").getText();
        return Actualtext.toLowerCase().contains(expectedText.toLowerCase());
    }

    public String verifyAlreadyHaveAccountText(){
        String actualText = getElement(ALREADY_HAVE_ACCOUNT_TEXT,"ALREADY HAVE AN ACCOUNT? text").getText();
        return actualText;
    }

    public Boolean verifyProgressBarSegmentForRegisteredUser(String count){
        Boolean verifyProgressBar = driver.findElement(By.id(PROGRESS_BAR)).isDisplayed();
//        Boolean verifyProgressBarLockIcon = driver.findElement(By.id(PROGRESS_BAR_LOCK_ICON)).isDisplayed();
        String progress_bar_lock_text = driver.findElement(By.id(PROGRESS_BAR_LOCK_TEXT)).getText();
        Boolean verify_pb_lock_text = progress_bar_lock_text.contains("Level up now!");
        String progress_bar_count = driver.findElement(By.id(PROGRESS_BAR_COUNT)).getText();
        Boolean verify_pb_count = progress_bar_count.contains(count);
        return verifyProgressBar && verify_pb_lock_text && verify_pb_count;
    }
}




