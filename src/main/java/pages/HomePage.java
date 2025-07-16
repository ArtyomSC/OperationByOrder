package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePage extends BasePage {
    private By welcomeButton = By.id("popup-confirm-welcome-button");
    private By menuTreeFilter = By.id("left-menu-form:tabView:treeFilterInput");
    private By messageContainer = By.className("ui-growl-title");
    private WebDriverWait wait;

    public HomePage() {
        super();
    }

    public void clickWelcomeButton() {
        driver.findElement(welcomeButton).click();
        ajaxWait();
    }

    public void findBusinessProcess(String businessProcess) {
        driver.findElement(menuTreeFilter).sendKeys(businessProcess);
        ajaxWait();
    }

    public void clickBusinessProcessName(String businessProcessName) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOfElementLocated(By.xpath(String.format("//span[contains(text(),'%s')]", businessProcessName)))).click();
    }

    public String getMessage() {
        ajaxWait();
        return driver.findElement(messageContainer).getText();
    }

    public void openBusinessProcess(String businessProcessName) {
        clickWelcomeButton();
        findBusinessProcess(businessProcessName);
        clickBusinessProcessName(businessProcessName);
    }

    public void checkMessage(String message) {
        Assertions.assertEquals(message, getMessage());
    }
}
