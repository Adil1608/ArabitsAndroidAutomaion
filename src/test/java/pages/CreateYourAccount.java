package pages;

import org.openqa.selenium.By;

public class CreateYourAccount extends BaseMethods {

    /** LOCATORS **/
    private String CREATE_ACCOUNT_TEXT = "createAccountFragmentTxtTitleCreateAccount";
    private String BTN_BACK_ARROW = "baseHeaderIvClose";

    public String verifyCreateAccountText(){
        sleep(2000);
        String createAccountText = driver.findElement(By.id(CREATE_ACCOUNT_TEXT)).getText();
        return createAccountText;
    }

    public void tapBackArrow(){
        driver.findElement(By.id(BTN_BACK_ARROW)).click();
    }
}
