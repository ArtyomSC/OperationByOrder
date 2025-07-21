package pages;

import enums.BusinessProcessName;
import enums.Message;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import to.OperationDataTO;

import static enums.BusinessProcessName.CASH_VALUABLES_RECEPTION_BY_ORDER;
import static enums.Message.RECEIVED_AMOUNT_ERROR;

public class ValuesByOrderPaymentPage extends BasePage {
    private By amountReceiptErrorMessage = By.className("ui-growl-title");
    private By receivedSumInput = By.id("main-content-form:input-table:0:received_input");

    public String getAmountReceiptErrorMessage() {
        return driver.findElement(amountReceiptErrorMessage).getText();
    }

    public void checkAmountReceiptErrorMessage(Message message) {
        Assertions.assertEquals(message.getMessage(), (getAmountReceiptErrorMessage()));
    }

    public void setReceivedAmount(double amount) {
        driver.findElement(receivedSumInput).sendKeys(String.valueOf(amount));
    }

    public HomePage addPaymentData(OperationDataTO operationDataTO, BusinessProcessName businessProcessName) {
        clickProceedButton();
        if (businessProcessName.getBusinessProcessName().equals(CASH_VALUABLES_RECEPTION_BY_ORDER.getBusinessProcessName())) {
            checkAmountReceiptErrorMessage(RECEIVED_AMOUNT_ERROR);
            setReceivedAmount(operationDataTO.getAmount());
            clickProceedButton();
        }
        return new HomePage();
    }
}
