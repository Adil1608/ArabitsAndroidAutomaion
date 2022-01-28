package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Profile;
import pages.CommonMethods;
import pages.Login;
import pages.SetUp;
import pages.Levels;
import utils.ConfigReader;


public class LogoutLogInTest {
     /** The following test is covering Login/Logout functionality,
     * as well as, guest and registered user accesses, namely
     * Guest user:
     * * A Guest user accesses the application without a premium resources,
     * * A Guest user has correct username *
     * * A Guest user successfully logs out *
     * Registered (subscribed) user:
     * * Logs in with his credentials and can access the dashboard.
     * * User accesses the application with premium content *
     * * Logged in user info matches with himself *
     * */

    CommonMethods commonMethods;
    Login login;
    Levels levels;
    Profile profile;
    SoftAssert softAssert = new SoftAssert();
    JSONObject userCredentials = ConfigReader.getUserConfig();
    String subscribedUserEmail = userCredentials.get("subscribedUserEmail").toString();
    String subscribedUserPass = userCredentials.get("subscribedUserPass").toString();

    @Test
    public void TestLogoutLogIn() {
        SetUp.initalize();
        commonMethods = new CommonMethods();
        commonMethods.closeWelcomingDialog();
        commonMethods.clickNextButton();
        commonMethods.clickNextButton();
        commonMethods.clickNextButton();
        commonMethods.clickSkipButton();
        commonMethods.skipSubscriptionContinueWithFreeLessons();
        commonMethods.goToLevelsPage();
        commonMethods.scroll_down(); //rm

        // Check guest user doesn't have accesses to premium content
        levels = new Levels();
        levels.openLevel("Level 1"); //"Foundation"
        levels.openLesson("Feelings");

        softAssert.assertTrue(commonMethods.isSubscriptionPopUpDisplayed(),
                "Subscription pop-up is displayed");
        commonMethods.closeSubscriptionPopUp();

        // Check if guest user have accesses to non-premium content
        levels.openLesson("The Family");
        softAssert.assertTrue(levels.isTopicsScreenLoaded(), "Topics screen loaded");
        commonMethods.clickBackButton();
        commonMethods.clickBackButton();

        // Check if guest username is correct
        commonMethods.goToProfilePage();

        profile = new Profile();
        profile.openAccountSettings();
        softAssert.assertTrue(profile.getUsernameFiledValue().contains("Guest"),
                "Guest username is correct");
        commonMethods.clickBackButton();
        profile.clickLogIn();

        // Login with Registered and subscribed user
        login = new Login();
        login.login(subscribedUserEmail, subscribedUserPass);

        // Check if registered-subscribed user have accesses to premium content
        levels.openLevel("Level 1");
        levels.openLesson("Feelings");
        softAssert.assertTrue(levels.isTopicsScreenLoaded(), "Topics screen loaded");
        commonMethods.clickBackButton();
        commonMethods.clickBackButton();

        // Verifying logged in user email
        commonMethods.goToProfilePage();
        profile.openAccountSettings();
        String email = profile.getEmaiFieldlValue();
        softAssert.assertEquals(email, subscribedUserEmail,
                "Logged in user email is correct");
        softAssert.assertAll();
        commonMethods.clickBackButton();
        profile.openProfileSettings();

        // Logout
        profile.clickLogout();
        profile.clickConfirmLogout();
    }
}
