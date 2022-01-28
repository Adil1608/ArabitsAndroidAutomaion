package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.Profile;
import pages.CommonMethods;
import pages.Levels;
import utils.ConfigReader;
import pages.SetUp;

public class RenewSubscriptionTest {
    Levels levels;
    Profile profile;
    CommonMethods commonMethods;
    JSONObject userCredentials = ConfigReader.getUserConfig();
    JSONObject locators = ConfigReader.getLocators();
    String subscriptionExpiredUser = userCredentials.get("subscriptionExpiredUser").toString();
    String subscriptionExpiredUserPass = userCredentials.get("password").toString();


    @Test
    public void TestTopic() throws InterruptedException {
        System.out.println(subscriptionExpiredUser);
        System.out.println(subscriptionExpiredUserPass);





//        SetUp.initalize();
//        commonMethods = new CommonMethods();
//        levels = new Levels();
//        //applicationPages = new ApplicationPages();
//        commonMethods.closeWelcomingDialog();
//        commonMethods.closeBitFreeDialog();
//        levels.openLevel("Level 1"); //"Foundation"
//        levels.openLesson("Greetings and Introduction"); //"Letter set 1"
//        levels.openTopic("Vocabulary");
//        levels.closeTopicIntroductionPopUp();
//        levels.completeTopic();



        //softAssert.assertAll();

        // arabits.automation+1790@gmail.com



        // General
        // to get background
        // short xpath:   //android.widget.ImageView[contains(@resource-id,"Background")]
        // long xpath: //*[@resource-id="com.alefeducation.arabits.dev:id/activitiesActivityMainContainer"]/*/android.widget.ImageView[contains(@resource-id,"Background")]
        // check by title or background in @resource-id attr activityVocabularyBackgroundIV/"activityMCQBackgroundIV"

        //  Vocab
        // title "Vocabulary" - com.alefeducation.arabits.dev:id/activityVocabularyFragmentTitleTV
        // image view background -  com.alefeducation.arabits.dev:id/activityVocabularyBackgroundIV
        // next btn - com.alefeducation.arabits.dev:id/activityVocabularyFragmentNextBtn

        // MCQ
        // title "Questions" - com.alefeducation.arabits.dev:id/activityMCQFragmentTitleTV
        // image view background -  com.alefeducation.arabits.dev:id/activityMCQBackgroundIV
        // next btn - com.alefeducation.arabits.dev:id/activityMCQFragmentNextBtn

        // generic xpath for next btn: contains FragmentNextBtn

        // mcq options - com.alefeducation.arabits.dev:id/activityMCQFragmentAnswerItemTV   - {~parent activityMCQFragmentAnswerItemContainer}
        // mcq validation pop-up next btn - com.alefeducation.arabits.dev:id/activityMCQAnsweredDialogNextTV

        // completion pop-up title - com.alefeducation.arabits.dev:id/practiceCompletionDialogHeadingTV
        // completion pop-up Continue btn - com.alefeducation.arabits.dev:id/practiceCompletionDialogPositiveBtn
        // completion pop-up Redo btn - com.alefeducation.arabits.dev:id/practiceCompletionDialogHeadingTV


    }
}
