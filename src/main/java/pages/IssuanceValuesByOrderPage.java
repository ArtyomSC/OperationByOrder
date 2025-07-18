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

public class IssuanceValuesByOrderPage extends BasePage {
    private By currencyKindLabel = By.id("main-content-form:kind_label");
    private By amountByDocument = By.id("main-content-form:amount_input");
    private By proceedButton = By.name("main-content-form:confirm");
    private By categoryLabel = By.id("main-content-form:category_label");
    private By amountIssue = By.id("main-content-form:amount-issue_input");
    private By amountReceiptCurrency = By.id("main-content-form:issue-amount-currency");
    private By amountByDocumentErrorMessage = By.className("ui-messages-error-summary");
    private By amountByDocumentRequiredFieldErrorMessage = By.id("main-content-form:amount-messages");
    private By amountReceiptRequiredFieldErrorMessage = By.id("main-content-form:issue-amount-messages");
    private By kindRequiredFieldErrorMessage = By.id("main-content-form:kindMessages");


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
        changeFocus();
        ajaxWait();
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

    public String getKindRequiredFieldMessage() {
        return driver.findElement(kindRequiredFieldErrorMessage).getText();
    }

    public void checkKindRequiredFieldMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getKindRequiredFieldMessage());
    }

    public String getAmountReceiptRequiredFieldMessage() {
        return driver.findElement(amountReceiptRequiredFieldErrorMessage).getText();
    }

    public void checkAmountReceiptRequiredFieldMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getAmountReceiptRequiredFieldMessage());
    }

    public String getAmountByDocumentRequiredFieldMessage() {
        return driver.findElement(amountByDocumentRequiredFieldErrorMessage).getText();
    }

    public void checkAmountByDocumentRequiredFieldMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getAmountByDocumentRequiredFieldMessage());
    }


    public void checkRequiredFieldMessage(Message message) {
        checkKindRequiredFieldMessage(message);
        checkAmountReceiptRequiredFieldMessage(message);
        checkAmountByDocumentRequiredFieldMessage(message);
    }

    public String getAmountByDocumentErrorMessage() {
        return driver.findElement(amountByDocumentErrorMessage).getText();
    }

    public void checkAmountByDocumentErrorMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getAmountByDocumentErrorMessage());
    }

    public int getAmountSum() {
        return (int) Double.parseDouble(driver.findElement(amountIssue).getAttribute("value").replace(',', '.'));
    }

    public String getAmountCurrencyKind() {
        return driver.findElement(amountReceiptCurrency).getText();
    }

    public void checkAmountSum(int amount) {
        Assertions.assertEquals(amount, getAmountSum());
    }

    public void checkAmountCurrencyKind(String currencyKind) {
        Assertions.assertEquals(currencyKind, getAmountCurrencyKind());
    }

    public HomePage runIssuanceValuesByOrderProcess(OperationDataTO operationDataTO) {
        checkCategory(CASH);
        clickProceedButton();
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR);
        setCurrencyKind(operationDataTO.getCurrencyKindName());
        clickProceedButton();
        checkAmountByDocumentErrorMessage(NULL_AMOUNT_ERROR);
        setAmountByDocument(operationDataTO.getAmount());
        checkAmountSum(operationDataTO.getAmount());
        checkAmountCurrencyKind(operationDataTO.getCurrencyKindCode());
        clickProceedButton();
        clickProceedButton();
        return new HomePage();
    }
}
