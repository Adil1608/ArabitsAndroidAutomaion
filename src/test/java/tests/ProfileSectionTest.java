package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import utils.EmailReader;


public class ProfileSectionTest extends BaseTest {
    /**
     * The following test is covering Profile Creation, Subcription, as well as,
     * correctness of username, email address, avatar, premium or non premium,
     * for both free and premium users.
     * <p>
     * Free user:
     * Create profile - Create user with required information.
     * View - View created profile information.
     * Edit profile- Edit existing user profile
     * Avatar change- Change avatar of user.
     * <p>
     * Checks subscription feasibility
     * Subscribe first time - Subscribe first time
     * Validates subscription details
     * <p>
     * As a Premium User:
     * Edit profile fields (username and name)
     * Views created profile information.
     * Checks Premium Avatars are accessible
     */


    String email;
    String name;
    String username;
    String premiumUsersUsername, premiumUsersName;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TestProfileCreationSubscription() throws InterruptedException {
        SetUp.initalize();
        commonMethods = new CommonMethods();
        commonMethods.closeWelcomingDialog();
        commonMethods.clickNextButton();
        commonMethods.clickNextButton();
        commonMethods.clickNextButton();
        commonMethods.clickSkipButton();
        commonMethods.skipSubscriptionContinueWithFreeLessons();
        commonMethods.goToProfilePage();

        /** Account Settings Page > account edit screen */
        profile = new Profile();
        profile.openAccountSettings();
        profile.clickEditButton();

        // 1. generate Username Return Value
        profile.clickRefreshUsernameButton();
        username = profile.getUsernameFiledValue();
        // 2. enter name
        name = profile.enterNameReturnValue();
        // 3. enter unique email
        email = profile.enterUniqueEmailReturnValue();
        // 3.1. click on a free space to make tool tip disappear
        profile.clickOnFreeSpaceOnScreen();
        // 4. click save btn
        profile.clickSaveButton();

        /** Account Settings Page > Profile creation Page */
        //applicationPages.scroll();
        // 5. enter passwd
        profile.enterRegistrationPasswd();
        // 6. confirm passwd:: com.alefeducation.arabits.dev:id/accountInfoFragmentEditTextConfirmPassword
        profile.enterRegistrationConfirmationPasswd();

        // 7. click agree terms checkbox
        profile.clickAgreeTermsCheckbox();

        // 8. click agree privacy checkbox:: com.alefeducation.arabits.dev:id/accountInfoFragmentPrivacyPolicyCB
        profile.clickAgreePrivacyCheckbox();

        // 9. click Create Account btn (scroll):: com.alefeducation.arabits.dev:id/accountInfoBtnContinue
        profile.scroll_down();
        profile.clickCreateAccountButton();

        // Enter verification code
//         String verificationCode = EmailReader.getVerificationCode();
        // profile.explicit_wait_for_element_send_keys("com.alefeducation.arabits.dev:id/verifyEmailFragmentEditTextCode", verificationCode);
        profile.enterVerificationCode();

        // Click confirm {check enabled then click}
        profile.clickConfirmButton();

        // assert congrats message
        softAssert.assertTrue(profile.isCongratsMessageDisplayed(),
                "Congrats message is displayed");

        // Click Congrats activity Done button
        profile.clickCongratsActivityDoneButton();


        softAssert.assertEquals(profile.getUsernameFiledValue(), username,
                "Entered Username is correct after registration");
        softAssert.assertEquals(profile.getNameFiledValue(), name,
                "Entered Name is correct after registration");
        softAssert.assertEquals(profile.getEmaiFieldlValue(), email,
                "Entered Email is correct after registration");


        // click change avatar pencil
        profile.clickChangeAvatarPencil();

        // try selecting premium avatar
        profile.clickOnLockedPremiumAvatar();

        // check subscription pop-up is displayed
        softAssert.assertTrue(commonMethods.isSubscriptionPopUpDisplayed(),
                "Subscription pop-up is displayed");
        commonMethods.closeSubscriptionPopUp();

        // click change avatar pencil
        // profile.explicit_wait_for_element_click("com.alefeducation.arabits.dev:id/icEdit");
        profile.clickChangeAvatarPencil();

        // choose available avatar
        // String availableAvatarsXpath = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/image\"][not( ../*[contains(@resource-id,\"crossover\")] )]";
        // profile.explicit_wait_for_element_click(availableAvatarsXpath);
        profile.selectFromAvailableAvatars();

        // checking avatar image presence after change (Note: as no unique identifier for avatars so no way to compare yet)
        profile.getAvatarImage();
        commonMethods.clickBackButton();

        // Todo: check with back-end team API to get list of free users,
        //  in order to split subscription flow into another test using user from the API list

        /** Subscription flow*/
        profile.openProfileSettings();
        profile.openSubscriptionSection();
        softAssert.assertEquals(profile.getNoActiveSubscriptionMsg(),
                "No active subscriptions.");

        // TODO: uncomment when bug/feature is resolved
        /*
        profile.enterAccessCode();
        // click keyboard entre here
        String subscriptionMessage = profile.validateSubscriptionReturnMsg();
        softAssert.assertEquals(subscriptionMessage, "1 year subscription");
        */

        /** Premium user flow*/
        commonMethods.clickBackButton();
        commonMethods.clickBackButton();
        profile.openAccountSettings();
        profile.clickEditButton();

        // 1. Change Username and name
        profile.clickRefreshUsernameButton();
        premiumUsersUsername = profile.getUsernameFiledValue();
        premiumUsersName = profile.enterNameReturnValue();
        profile.clickOnFreeSpaceOnScreen();
        profile.clickSaveButton();

        softAssert.assertNotEquals(premiumUsersUsername, username, "Username is changed.");
        softAssert.assertNotEquals(premiumUsersName, name, "Name is changed.");

        // select premium avatar
        profile.clickChangeAvatarPencil();
        // profile.scroll(0.5, 0.68,0.5,0.89); //todo check why not scrolling
        // profile.clickOnUnlockedPremiumAvatar(); //todo check why not finding (after manual scroll finds 2nd premium avatar)
        profile.selectFromAvailableAvatars();
        profile.getAvatarImage();

        softAssert.assertAll();
    }

    @Test
    public void TestProfilePage() throws InterruptedException {
        SetUp.initalize();
        commonMethods = new CommonMethods();
        commonMethods.skipOnboading();
        commonMethods.skipSubscriptionContinueWithFreeLessons();
        commonMethods.goToProfilePage();
        profile = new Profile();
        Boolean result = profile.verifyUserProfileName();
        softAssert.assertTrue(result);
        softAssert.assertAll();
    }

    @Test
    public void TestProfileLoginButton() throws InterruptedException {
        SetUp.initalize();
        commonMethods = new CommonMethods();
        commonMethods.skipOnboading();
        commonMethods.skipSubscriptionContinueWithFreeLessons();
        commonMethods.goToProfilePage();
        profile = new Profile();
        Boolean result = profile.verifyUserProfileName();
        softAssert.assertTrue(result);
        profile.tapLoginLink();
        login = new Login();
        String loginPageText = login.verifyLoginPage();

        softAssert.assertTrue(loginPageText.contains("Log in to continue"));
        login.tapBackArrow();
        profile.tapCreateYourAccountBtn();
        createAccount = new CreateYourAccount();
        String createAccountText = createAccount.verifyCreateAccountText();
        softAssert.assertTrue(createAccountText.contains("Create your account"));

        createAccount.tapBackArrow();
        profile.openProfileSettings();
        settings = new Settings();
        String settingText = settings.verifySettingText();
        softAssert.assertTrue(settingText.contains("Settings"));
        softAssert.assertAll();
    }
}
