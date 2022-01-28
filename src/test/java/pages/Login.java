package pages;

import org.openqa.selenium.By;

/** Login Page **/
public class Login extends BaseMethods{

    /** LOCATORS **/
    private String LOGINPAGE_TEXT = "loginFragmentTxtContinue";
    private String LOGINPAGE_DO_IT_LATER_ARROW = "loginFragmentTxtDoitLater";
    private String EMAIL_FIELD = "id=>loginFragmentEditTextEmail";
    private String PASSWORD_FIELD = "id=>loginFragmentEditTextPassword";
    private String LOGIN_BTN = "id=>loginFragmentBtnLogin";


    public void login(String email, String pass){
        explicit_wait_for_element_send_keys("//*[contains(@resource-id,\"loginFragmentEditTextEmail\")]", email);
        explicit_wait_for_element_send_keys("//*[contains(@resource-id,\"loginFragmentEditTextPassword\")]", pass);
        explicit_wait_for_element_click("//*[contains(@resource-id,\"loginFragmentBtnLogin\")]");
    }

    public String verifyLoginPage(){
        sleep(1000);
        String loginText = driver.findElement(By.id(LOGINPAGE_TEXT)).getText();
        return loginText;
    }

    public void tapBackArrow(){
        driver.findElement(By.id(LOGINPAGE_DO_IT_LATER_ARROW)).click();
    }

    public void loginIntoApplication(String username, String password){
        sendData(EMAIL_FIELD,username);
        sendData(PASSWORD_FIELD,password);
    }

    public void clickLoginBtn(){
        elementClick(LOGIN_BTN,"Login button");
    }
}
