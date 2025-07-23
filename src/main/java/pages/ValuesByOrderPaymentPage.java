package pages;

import enums.Message;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import to.OperationDataTO;

import static enums.Message.RECEIVED_AMOUNT_ERROR;

public class ValuesByOrderPaymentPage extends BasePage {
    private By amountReceiptErrorMessage = By.className("ui-growl-title");
    private By receivedSumInput = By.id("main-content-form:input-table:0:received_input");

    public String getAmountReceiptErrorMessage() {
        return driver.findElement(amountReceiptErrorMessage).getText();
    }

    public void checkAmountReceiptErrorMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), getAmountReceiptErrorMessage());
    }

    public void setReceivedAmount(double amount) {
        driver.findElement(receivedSumInput).sendKeys(String.valueOf(amount));
    }

    public void addPaymentData(OperationDataTO operationDataTO) {
        checkAmountReceiptErrorMessage(RECEIVED_AMOUNT_ERROR);
        setReceivedAmount(operationDataTO.getAmount());
        clickProceedButton();
    }
}
