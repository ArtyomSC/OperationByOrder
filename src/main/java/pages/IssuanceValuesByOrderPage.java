package pages;

import org.openqa.selenium.By;
import to.OperationDataTO;

public class IssuanceValuesByOrderPage extends BasePage {
    private By currencyKindLabel = By.id("main-content-form:kind_label");
    private By amountByDocument = By.id("main-content-form:amount_input");
    private By proceedButton = By.name("main-content-form:confirm");

    public IssuanceValuesByOrderPage() {
        super();
    }

    public void setCurrencyKind(String currencyName) {
        driver.findElement(currencyKindLabel).click();
        driver.findElement(By.xpath(String.format("//li[@data-label='%s']", currencyName))).click();
        ajaxWait();
    }

    public void setAmountByDocument(int amount) {
        driver.findElement(amountByDocument).click();
        driver.findElement(amountByDocument).sendKeys(String.valueOf(amount));
    }

    public void clickProceedButton() {
        driver.findElement(proceedButton).click();
        ajaxWait();
    }

    public HomePage runIssuanceValuesByOrderProcess(OperationDataTO operationDataTO) {
        setCurrencyKind(operationDataTO.getCurrencyKind());
        setAmountByDocument(operationDataTO.getAmount());
        clickProceedButton();
        clickProceedButton();
        return new HomePage();
    }
}
