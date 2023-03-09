package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button/span[text()='Place Order']")
    public WebElement placeOrderButton;
}
