package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SuccessfulLoginPage {
    @FindBy(id = "flash")
    private SelenideElement loginMessage;

    @FindBy(css = "a.button")
    private SelenideElement logoutButton;

    public void shouldLogin() {
        loginMessage.shouldBe(visible, text("You logged into a secure area!"));
    }

    public void logout() {
        logoutButton.click();
    }
}
