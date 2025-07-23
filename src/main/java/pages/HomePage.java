package pages;

import enums.BusinessProcessName;
import enums.Message;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage extends BasePage {
    private By welcomeButton = By.id("popup-confirm-welcome-button");
    private By menuTreeFilter = By.id("left-menu-form:tabView:treeFilterInput");
    private By messageContainer = By.className("ui-growl-title");
    private By blockerElement = By.xpath("//*[@id='left-menu-form:tabView:j_idt567_blocker' and @style]");

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(invisibilityOfElementLocated(blockerElement));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//span[contains(text(),'%s')]", businessProcessName)))).click();
        ajaxWait();
    }

    public String getMessage() {
        return driver.findElement(messageContainer).getText();
    }

    public void openBusinessProcess(BusinessProcessName businessProcessName) {
        findBusinessProcess(businessProcessName.getBusinessProcessName());
        clickBusinessProcessName(businessProcessName.getBusinessProcessName());
    }

    public void checkMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getMessage());
    }

    public void clearSearch() {
        driver.findElement(menuTreeFilter).clear();
        ajaxWait();
    }
}
