import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class CLP {
    private WebDriver driver;
    private HomePage homepage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private GuerillaMail guerillaMail;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void destroy() {
        driver.quit();
    }

    @Test
    public void purchaseIphone() throws InterruptedException {
        driver.manage().window().maximize();

        // Home page
        driver.get("https://www.flipkart.com/");
        homepage = new HomePage(driver);

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(homepage.closeModalButton));

            homepage.closeModalButton.click();
        } catch (TimeoutException e) {
            System.out.println("No modal popped up");
        }

        homepage.searchBar.sendKeys("iphone");
        homepage.searchBar.submit();

        // Search results page
        searchPage = new SearchPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchPage.storageDropdown));

        searchPage.storageDropdown.click();
        searchPage.memoryCheckbox.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.stalenessOf(searchPage.getFirstProduct()));

        searchPage.getFirstProduct().click();

        // Product page in new window
        String originalHandle = driver.getWindowHandle();
        for (String handle: driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.close();
                driver.switchTo().window(handle);
            }
        }

        productPage = new ProductPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(productPage.addToCartButton));

        productPage.addToCartButton.click();

        driver.manage().window().maximize();

        Thread.sleep(3000);

        productPage.cartLink.click();

        cartPage = new CartPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(cartPage.placeOrderButton));

        cartPage.placeOrderButton.click();

        checkoutPage = new CheckoutPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkoutPage.emailInput));

        checkoutPage.emailInput.sendKeys("test@pokemail.com");
        checkoutPage.continueButton.click();
    }
}
