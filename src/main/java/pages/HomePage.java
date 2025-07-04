package pages;

import enums.BusinessProcessName;
import enums.Message;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePage extends BasePage {
    private By welcomeButton = By.id("popup-confirm-welcome-button");
    private By menuTreeFilter = By.id("left-menu-form:tabView:treeFilterInput");
    private By businessProcessName = By.xpath("//*[@id='left-menu-form:tabView:left-menu-main-tree:0_0_0']/span/span[3]/span");
    private By messageContainer = By.xpath("//*[@id='main-content-form:messages_container']//div[2]/span");
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

    public CashValuablesReceptionByOrderPage clickBusinessProcessName() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOfElementLocated(businessProcessName)).click();
        return new CashValuablesReceptionByOrderPage();
    }

    public String getMessage() {
        return driver.findElement(messageContainer).getText();
    }

    public CashValuablesReceptionByOrderPage openBusinessProcess(BusinessProcessName businessProcessName) {
        clickWelcomeButton();
        findBusinessProcess(businessProcessName.getBusinessProcessName());
        return clickBusinessProcessName();
    }

    public void checkMessage(Message message, String expMessage) {
        Assertions.assertEquals(message.getMessage(), expMessage);
    }
}
