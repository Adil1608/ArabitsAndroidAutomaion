package tests;

import org.testng.annotations.Test;
import pages.SetUp;
import pages.CommonMethods;

public class ExploreModuleTest {
    CommonMethods commonMethods;

    @Test
    public void TestExplore() {
        /** Go to explore section*/
        SetUp.initalize();
        commonMethods = new CommonMethods();
        commonMethods.closeWelcomingDialog();
        commonMethods.clickNextButton();
        commonMethods.clickNextButton();
        commonMethods.clickNextButton();
        commonMethods.clickSkipButton();
        commonMethods.skipSubscriptionContinueWithFreeLessons();
        commonMethods.goToExplorePage();
        commonMethods.closeExploreDialog();
    }
}
