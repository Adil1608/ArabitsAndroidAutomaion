package pages;

import org.openqa.selenium.By;

public class CommonMethods extends BaseMethods {



    private String CONTINUE_BTN_WELCOME_MODAL = "id=>welcomeDialogContinueBTN";
    private String NEXT_BTN_ONBOARDING = "id=>btnNext";

    /** Pop-ups **/
    public void closeWelcomingDialog(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"welcomeDialogContinueBTN\")]");
        sleep(2000);
    }
    public void closeBitFreeDialog(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"freeBitDialogSubscribeBTN\")]");
    }
    public void closeExploreDialog(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"exploreOnboardingCardsExplorBTN\")]");
    }
    public boolean isSubscriptionPopUpDisplayed(){
        return explicit_wait_check_element_displayed("com.alefeducation.arabits.dev:id/premiumContentDialogHeadIV");
    }
    public void closeSubscriptionPopUp(){
        explicit_wait_for_element_click("com.alefeducation.arabits.dev:id/premiumContentDialogCancel");
    }
    public void skipSubscriptionContinueWithFreeLessons(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"tv_free_lessons\")]");
    }

    /** NavBar **/
    public void goToProfilePage(){
        String xpath = "//*[@resource-id='com.alefeducation.arabits.dev:id/actionsProfile']";
        explicit_wait_for_element_click(xpath);
    }

    public void goToExplorePage(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Explore']/android.view.ViewGroup/android.widget.TextView")).click();
//        String xpath = "//android.widget.FrameLayout[@content-desc=\"Explore\"]/android.view.ViewGroup/android.widget.TextView";
//        explicit_wait_for_element_click(xpath);
    }
    public void goToLevelsPage(){
        String xpath = "//*[contains(@resource-id,\"actionsLevels\")]";
        explicit_wait_for_element_click(xpath);
    }
    /**Next/Back/Skip buttons*/
    public void clickNextButton(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"btnNext\")]");
    }
    public void clickBackButton(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"Close\") or contains(@resource-id,\"BackButton\")]");
    }
    public void clickErrorBackButton(){
        explicit_wait_for_element_click("com.alefeducation.arabits.dev:id/errorFragmentBackBtn");
    }
    public void clickSkipButton(){
        explicit_wait_for_element_click("//*[contains(@resource-id,\"skip\")]");
    }

    public void closeWelcomeDialog(){
        waitForElement(CONTINUE_BTN_WELCOME_MODAL,10);
        elementClick(CONTINUE_BTN_WELCOME_MODAL,"Continue button on Welcome Modal");
    }

    public void tapNextBtn(){
        waitForElement(NEXT_BTN_ONBOARDING,10);
        elementClick(NEXT_BTN_ONBOARDING,"Next button on Onboarding");
    }

    public void skipOnboading(){
//        driver.launchApp();
//        Enum app_state  = driver.queryAppState("com.alefeducation.arabits.dev");
//        if (app_state != RUNNING_IN_FOREGROUND){
//            driver.launchApp();
//        }
        sleep(2000);
        closeWelcomeDialog();
        tapNextBtn();
        tapNextBtn();
        tapNextBtn();
        sleep(2000);
        clickSkipButton();
        sleep(1000);
    }
}
