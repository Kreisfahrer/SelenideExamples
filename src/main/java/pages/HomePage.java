package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(how = How.CSS, using = "li > a")
    private List<SelenideElement> references;

    public <PageObjectClass> PageObjectClass goTo(String ref, Class<PageObjectClass> pageObjectClassClass) {
        for (SelenideElement element : references) {
            if (element.text().equals(ref)) {
                element.click();
                break;
            }
        }
        return page(pageObjectClassClass);
    }
}
