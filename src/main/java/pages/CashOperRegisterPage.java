package pages;

import enums.BusinessProcessName;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import to.OperationDataTO;

public class CashOperRegisterPage extends BasePage {
    private By searchButton = By.id("main-content-form:search");
    private By sum = By.id("main-content-form:htable:0:htable-sum");
    private By kindName = By.id("main-content-form:htable:0:htable-kind");
    private By businessProcessName = By.id("main-content-form:htable:0:htable-operation");

    public CashOperRegisterPage() {
        super();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void checkOperation(OperationDataTO operationDataTO, BusinessProcessName businessProcessName) {
        clickSearchButton();
        Assertions.assertEquals(operationDataTO.getAmount(), getAmount());
        Assertions.assertEquals(operationDataTO.getCurrencyKind().getCurrencyKindName(), getCurrencyKindName());
        Assertions.assertEquals(businessProcessName.getBusinessProcessName(), getBusinessProcessName());
    }

    private String getCurrencyKindName() {
        return driver.findElement(kindName).getText();
    }

    private String getBusinessProcessName() {
        return driver.findElement(businessProcessName).getText();
    }

    private Double getAmount() {
        return Double.parseDouble(driver.findElement(sum).getText().replace(",", "."));
    }
}
