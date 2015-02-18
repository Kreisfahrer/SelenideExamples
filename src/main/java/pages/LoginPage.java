package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(id = "username")
    private SelenideElement userName;

    @FindBy(id = "password")
    private SelenideElement password;

    @FindBy(css = "button[type=submit]")
    private SelenideElement submit;

    @FindBy(id = "flash")
    private SelenideElement validationMessage;

    public LoginPage fillForm(String user, String pass) {
        userName.val(user);
        password.val(pass);
        return this;
    }

    public LoginPage submit() {
        submit.click();
        return this;
    }

    public SuccessfulLoginPage login(String user, String pass) {
        fillForm(user, pass);
        submit();
        return page(SuccessfulLoginPage.class);
    }

    public LoginPage setUserName(String user) {
        userName.val(user);
        return this;
    }

    public LoginPage setPassword(String pass) {
        password.val(pass);
        return this;
    }

    public void shouldNotLogin() {
        System.out.println("debug");
        validationMessage.should(Condition.appear, Condition.text("Your username is invalid!"));
    }

    public String getUserName() {
        return userName.val();
    }

    public String getPassword() {
        return password.val();
    }
}
