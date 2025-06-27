package pages;

import org.openqa.selenium.By;
import to.OperationDataTO;

public class CashValuablesReceptionByOrderPage extends BasePage {
    private By currencyKindLabel = By.id("main-content-form:kind_label");
    private By amountByDocument = By.id("main-content-form:amount_input");
    private By receivedInput = By.id("main-content-form:input-table:0:received_input");
    private By proceedButton = By.name("main-content-form:confirm");

    public CashValuablesReceptionByOrderPage() {
        super();
    }

    public void setCurrencyKind(String currencyName) {
        driver.findElement(currencyKindLabel).click();
        driver.findElement(By.xpath(String.format("//li[@data-label='%s']",currencyName))).click();
        ajaxWait();
    }

    public void setAmountByDocument(int amount) {
        driver.findElement(amountByDocument).click();
        driver.findElement(amountByDocument).sendKeys(String.valueOf(amount));
    }

    public void setReceivedAmount(int amount) {
        driver.findElement(receivedInput).sendKeys(String.valueOf(amount));
    }

    public void clickProceedButton() {
        driver.findElement(proceedButton).click();
        ajaxWait();
    }

    public HomePage runCashValuablesReceptionByOrderProcess(OperationDataTO operationDataTO) {
        setCurrencyKind(operationDataTO.getCurrencyKind());
        setAmountByDocument(operationDataTO.getAmount());
        clickProceedButton();
        setReceivedAmount(operationDataTO.getAmount());
        clickProceedButton();
        return new HomePage();
    }
}
