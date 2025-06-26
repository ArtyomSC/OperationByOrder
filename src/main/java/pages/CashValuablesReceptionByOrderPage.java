package pages;

import org.openqa.selenium.By;

public class CashValuablesReceptionByOrderPage extends BasePage {
    private By currencyKindLabel = By.id("main-content-form:kind_label");
    private By currencyBynKind = By.cssSelector("#main-content-form\\:kind_1");
    private By amountByDocument = By.id("main-content-form:amount_input");
    private By receivedInput = By.id("main-content-form:input-table:0:received_input");
    private By proceedButton = By.name("main-content-form:confirm");

    public CashValuablesReceptionByOrderPage() {
        super();
    }

    public void setCurrencyKind() {
        driver.findElement(currencyKindLabel).click();
        driver.findElement(currencyBynKind).click();
        ajaxWait();
    }

    public void setAmountByDocument(String amount) {
        driver.findElement(amountByDocument).click();
        driver.findElement(amountByDocument).sendKeys(String.valueOf(amount));
    }

    public void setReceivedAmount(String amount) {
        driver.findElement(receivedInput).sendKeys(amount);
    }

    public void clickProceedButton() {
        driver.findElement(proceedButton).click();
        ajaxWait();
    }

    public HomePage runCashValuablesReceptionByOrderProcess(String amount) {
        setCurrencyKind();
        setAmountByDocument(amount);
        clickProceedButton();
        setReceivedAmount(amount);
        clickProceedButton();
        return new HomePage();
    }
}
