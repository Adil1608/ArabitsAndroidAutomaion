package pages;
//import androidx.test.uiautomator.UiScrollable

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.EmailReader;
import java.util.List;
import java.util.Optional;

public class Levels extends BaseMethods {
    /** Levels Page **/
    public void openLevel(String levelName){
        String xpath = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/rowCoursesTxtNameEn\"]";
        explicit_wait_get_element_by_given_text_click(xpath, levelName);
    }
    public void openLesson(String lessonName){
        String xpath = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/lessonItemSubTextView\"]";
        explicit_wait_get_element_by_given_text_click(xpath, lessonName);
    }
    public void openTopic(String topicName){
        String xpath = "//*[@resource-id=\"com.alefeducation.arabits.dev:id/itemActivityTxtNameEn\"]";
        explicit_wait_get_element_by_given_text_click(xpath, topicName);
    }
    public void closeTopicIntroductionPopUp(){
        // Appears in Vocabulary start, with "Got it!" btn
        String xpath = "com.alefeducation.arabits.dev:id/learningObjectiveDialogBtn";
        explicit_wait_for_element_click(xpath);
    }
    public void completeTopic() throws InterruptedException {
        //String nextBtnXpath = "//*[contains(@resource-id,\"FragmentNextBtn\")]";
        //Thread.sleep(1000);
//        String nextBtnXpath = "//*[contains(@resource-id,\"FragmentNextBtn\") and contains(@isClickable,\"false\")]";
//        explicit_wait_for_element(nextBtnXpath);
        String nextBtnXpath = "//*[contains(@resource-id,\"FragmentNextBtn\") and contains(@focusable,\"false\")]";
        explicit_wait_for_element(nextBtnXpath);

        String nextBtnXpath2 = "//*[contains(@resource-id,\"FragmentNextBtn\") and contains(@focusable,\"true\")]";
        explicit_wait_for_element_click(nextBtnXpath2);


        //explicit_wait_element_to_be_enabled_click(nextBtnXpath);
    }
    public boolean isTopicsScreenLoaded() {
        String xpath = "com.alefeducation.arabits.dev:id/activityFragmentRecyclerView";
        return explicit_wait_check_element_displayed(xpath);
    }
}
