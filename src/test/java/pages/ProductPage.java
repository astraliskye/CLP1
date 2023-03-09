package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Page {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[text()[contains(., 'to cart')]]")
    public WebElement addToCartButton;
}
