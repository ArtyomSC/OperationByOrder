package pages;

import enums.Category;
import enums.Message;
import enums.OperationByOrderRequiredField;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import to.OperationDataTO;

import static enums.Category.CASH;
import static enums.Message.*;
import static enums.OperationByOrderRequiredField.*;

public class CashValuablesReceptionByOrderPage extends BasePage {
    private By currencyKindLabel = By.id("main-content-form:kind_label");
    private By amountByDocument = By.id("main-content-form:amount_input");
    private By receivedSumInput = By.id("main-content-form:input-table:0:received_input");
    private By proceedButton = By.name("main-content-form:confirm");
    private By categoryLabel = By.id("main-content-form:category_label");
    private By amountReceipt = By.id("main-content-form:amount-receipt_input");
    private By amountReceiptCurrency = By.id("main-content-form:issue-amount-currency");
    private By amountByDocumentErrorMessage = By.className("ui-messages-error-summary");
    private By amountReceiptErrorMessage = By.className("ui-growl-title");

    public CashValuablesReceptionByOrderPage() {
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
        changeFocus();
        ajaxWait();
    }

    public void setReceivedAmount(int amount) {
        driver.findElement(receivedSumInput).sendKeys(String.valueOf(amount));
    }

    public void clickProceedButton() {
        driver.findElement(proceedButton).click();
        ajaxWait();
    }

    public String getCategory() {
        return driver.findElement(categoryLabel).getText();
    }

    public void checkCategory(Category category) {
        Assertions.assertEquals(category.getCategory(), getCategory());
    }

    public String getAmountByDocumentErrorMessage() {
        return driver.findElement(amountByDocumentErrorMessage).getText();
    }

    public void checkAmountByDocumentErrorMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getAmountByDocumentErrorMessage());
    }

    public String getAmountReceiptErrorMessage() {
        return driver.findElement(amountReceiptErrorMessage).getText();
    }

    public void checkAmountReceiptErrorMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getAmountReceiptErrorMessage());
    }

    public String getKindRequiredFieldMessage(OperationByOrderRequiredField kind) {
        return driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]/following-sibling::div//span[@class='ui-message-error-detail']",
                kind.getRequiredField()))).getText();
    }

    public void checkKindRequiredFieldMessage(Message message, OperationByOrderRequiredField kind) {
        Assertions.assertEquals(message.getMessage(), getKindRequiredFieldMessage(kind));
    }

    public String getRequiredFieldMessageByAmountKind(OperationByOrderRequiredField amountKind) {
        return driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]/following-sibling::div//span[@class='ui-messages-error-summary']",
                amountKind.getRequiredField()))).getText();
    }

    public void checkRequiredFieldMessageByAmountKind(Message message, OperationByOrderRequiredField amountKind) {
        Assertions.assertEquals(message.getMessage(), getRequiredFieldMessageByAmountKind(amountKind));
    }

    public void checkRequiredFieldMessage(Message message) {
        checkKindRequiredFieldMessage(message, KIND);
        checkRequiredFieldMessageByAmountKind(message, AMOUNT_BY_DOCUMENT);
        checkRequiredFieldMessageByAmountKind(message, AMOUNT_RECEIPT);
    }

    public int getAmountReceipt() {
        return (int) Double.parseDouble(driver.findElement(amountReceipt).getAttribute("value").replace(',', '.'));
    }

    public String getAmountCurrencyKind() {
        return driver.findElement(amountReceiptCurrency).getText();
    }

    public void checkAmountReceipt(int amount) {
        Assertions.assertEquals(amount, getAmountReceipt());
    }

    public void checkAmountCurrencyKind(String currencyKind) {
        Assertions.assertEquals(currencyKind, getAmountCurrencyKind());
    }

    public HomePage runCashValuablesReceptionByOrderProcess(OperationDataTO operationDataTO) {
        checkCategory(CASH);
        clickProceedButton();
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR);
        setCurrencyKind(operationDataTO.getCurrencyKindName());
        clickProceedButton();
        checkAmountByDocumentErrorMessage(NULL_AMOUNT_ERROR);
        setAmountByDocument(operationDataTO.getAmount());
        checkAmountReceipt(operationDataTO.getAmount());
        checkAmountCurrencyKind(operationDataTO.getCurrencyKindCode());
        clickProceedButton();
        clickProceedButton();
        checkAmountReceiptErrorMessage(RECEIVED_AMOUNT_ERROR);
        setReceivedAmount(operationDataTO.getAmount());
        clickProceedButton();
        return new HomePage();
    }
}
