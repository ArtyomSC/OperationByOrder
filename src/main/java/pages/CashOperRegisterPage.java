package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import to.CashOperRegisterDataTO;

public class CashOperRegisterPage extends BasePage {
    private By searchButton = By.id("main-content-form:search");
    private By operation = By.xpath("//*[@id='main-content-form:htable_data']/tr[1]");
    private By row = By.xpath("//td");

    public CashOperRegisterPage() {
        super();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void checkOperation(CashOperRegisterDataTO cashOperRegisterDataTO) {
        clickSearchButton();
        Assertions.assertEquals(cashOperRegisterDataTO, getOperationData());
    }

    private WebElement getOperation() {
        return driver.findElement(operation);
    }

    private CashOperRegisterDataTO getOperationData() {
        return new CashOperRegisterDataTO(
                Double.parseDouble(getOperation().findElements(row).get(9).getText().replace(",", ".")),
                getOperation().findElements(row).get(8).getText(),
                getOperation().findElements(row).get(3).getText(),
                getOperation().findElements(row).get(7).getText());
    }
}
