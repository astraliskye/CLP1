package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Page {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input")
    public WebElement emailInput;

    @FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button")
    public WebElement continueButton;
}
