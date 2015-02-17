import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.BrowserPerClass;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.disappear;

public class HowToStartTest {

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://the-internet.herokuapp.com";
        Configuration.timeout = 10000;
    }

    @Test
    public void startTest() {
        open("/dynamic_controls");
        $(By.id("btn1")).click();
        $(By.id("checkbox")).should(disappear);
    }

    @Test
    public void collectionTest() {
        open("");
        $$("li > a").shouldHaveSize(35).filter(Condition.text("File")).shouldHaveSize(3)
                .shouldHave(texts("File Download", "File Upload", "Secure File Download"));
    }

    @Test
    public void startWebdriverTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.id("btn")).click();
        new WebDriverWait(driver, 10000).until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        driver.quit();
    }
}
