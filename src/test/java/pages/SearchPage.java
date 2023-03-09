package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Page {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstProduct() {
        return driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div[2]/div/div/div/a"));
    }

    @FindBy(xpath="//div[text()='Internal Storage']")
    public WebElement storageDropdown;

    @FindBy(xpath="//label/div[text()='256 GB & Above']")
    public WebElement memoryCheckbox;
}
