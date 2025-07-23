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
    private By categoryLabel = By.id("main-content-form:category_label");
    private By amountReceipt = By.id("main-content-form:amount-receipt_input");
    private By amountReceiptCurrency = By.id("main-content-form:issue-amount-currency");

    public CashValuablesReceptionByOrderPage() {
        super();
    }

    public void setCurrencyKind(String currencyName) {
        driver.findElement(currencyKindLabel).click();
        driver.findElement(By.xpath(String.format("//li[@data-label='%s']", currencyName))).click();
        ajaxWait();
    }

    public void setAmountByDocument(double amount) {
        driver.findElement(amountByDocument).click();
        driver.findElement(amountByDocument).sendKeys(String.valueOf(amount));
        changeFocus();
        ajaxWait();
    }

    public String getCategory() {
        return driver.findElement(categoryLabel).getText();
    }

    public void checkCategory(Category category) {
        Assertions.assertEquals(category.getCategory(), getCategory());
    }


    public void checkRequiredFieldMessage(Message message, OperationByOrderRequiredField field) {
        Assertions.assertEquals(message.getMessage(), driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]/following-sibling::div[last()]/div[last()]",
                field.getRequiredField()))).getText());
    }

    public double getAmountReceipt() {
        return Double.parseDouble(driver.findElement(amountReceipt).getAttribute("value").replace(',', '.'));
    }

    public String getAmountCurrencyKind() {
        return driver.findElement(amountReceiptCurrency).getText();
    }

    public void checkAmountReceipt(double amount) {
        Assertions.assertEquals(amount, getAmountReceipt());
    }

    public void checkAmountCurrencyKind(String currencyKind) {
        Assertions.assertEquals(currencyKind, getAmountCurrencyKind());
    }

    public void checkAmountByDocumentReceiptInputIsDisabled() {
        Assertions.assertFalse(driver.findElement(amountReceipt).isEnabled());
    }

    public void runCashValuablesReceptionByOrderProcess(OperationDataTO operationDataTO) {
        checkCategory(CASH);
        clickProceedButton();
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR, KIND);
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR, AMOUNT_RECEIPT);
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR, AMOUNT_BY_DOCUMENT);
        setCurrencyKind(operationDataTO.getCurrencyKind().getCurrencyKindName());
        clickProceedButton();
        checkRequiredFieldMessage(NULL_AMOUNT_ERROR, AMOUNT_BY_DOCUMENT);
        setAmountByDocument(operationDataTO.getAmount());
        checkAmountReceipt(operationDataTO.getAmount());
        checkAmountByDocumentReceiptInputIsDisabled();
        checkAmountCurrencyKind(operationDataTO.getCurrencyKind().getCurrencyKindCode());
        clickProceedButton();
    }
}
