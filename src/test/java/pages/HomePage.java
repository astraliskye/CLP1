package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[text()='✕']")
    public WebElement closeModalButton;

    @FindBy(name="q")
    public WebElement searchBar;
}
