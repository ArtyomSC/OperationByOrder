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
    private By categoryLabel = By.id("main-content-form:category_label");
    private By amountIssue = By.id("main-content-form:amount-issue_input");
    private By amountReceiptCurrency = By.id("main-content-form:issue-amount-currency");
    private By amountIssueInput = By.id("main-content-form:amount-issue");

    public IssuanceValuesByOrderPage() {
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

    public double getAmountSum() {
        return Double.parseDouble(driver.findElement(amountIssue).getAttribute("value").replace(',', '.'));
    }

    public String getAmountCurrencyKind() {
        return driver.findElement(amountReceiptCurrency).getText();
    }

    public void checkAmountSum(double amount) {
        Assertions.assertEquals(amount, getAmountSum());
    }

    public void checkAmountCurrencyKind(String currencyKind) {
        Assertions.assertEquals(currencyKind, getAmountCurrencyKind());
    }

    public void checkAmountByDocumentReceiptInputIsDisabled() {
        Assertions.assertTrue(driver.findElement(amountIssueInput).isDisplayed());
    }

    public void runIssuanceValuesByOrderProcess(OperationDataTO operationDataTO) {
        checkCategory(CASH);
        clickProceedButton();
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR, KIND);
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR, AMOUNT_BY_DOCUMENT);
        checkRequiredFieldMessage(REQUIRED_FIELD_ERROR, AMOUNT_ISSUE);
        setCurrencyKind(operationDataTO.getCurrencyKind().getCurrencyKindName());
        clickProceedButton();
        checkRequiredFieldMessage(NULL_AMOUNT_ERROR, AMOUNT_BY_DOCUMENT);
        setAmountByDocument(operationDataTO.getAmount());
        checkAmountByDocumentReceiptInputIsDisabled();
        checkAmountSum(operationDataTO.getAmount());
        checkAmountCurrencyKind(operationDataTO.getCurrencyKind().getCurrencyKindCode());
        clickProceedButton();
    }
}
