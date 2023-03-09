package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuerillaMail extends Page {
    public GuerillaMail(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstEmailRow() {
        return driver.findElement(By.xpath("//*[@id='mr_1']"));
    }

    @FindBy(id="inbox-id")
    public WebElement inboxIdButton;

    @FindBy(xpath="//*[@id='inbox-id']/input")
    public WebElement inboxIdInput;


}
