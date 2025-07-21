import dataProvider.OperationByOrderProcessData;
import org.testng.annotations.Test;
import pages.CashValuablesReceptionByOrderPage;
import pages.ValuesByOrderPaymentPage;
import to.OperationDataTO;

import static enums.BusinessProcessName.CASH_VALUABLES_RECEPTION_BY_ORDER;
import static enums.Message.OPERATION_COMPLETE;

public class CashValuablesReceptionByOrderProcessTest extends BaseTest {
    private CashValuablesReceptionByOrderPage cashValuablesReceptionByOrderPage = new CashValuablesReceptionByOrderPage();
    private ValuesByOrderPaymentPage valuesByOrderPaymentPage = new ValuesByOrderPaymentPage();

    @Test(dataProvider = "cashValuablesReceptionByOrderProcessData", dataProviderClass = OperationByOrderProcessData.class)
    public void testCashValuablesReceptionByOrderProcess(OperationDataTO operationDataTO) {
        homePage.openBusinessProcess(CASH_VALUABLES_RECEPTION_BY_ORDER);
        cashValuablesReceptionByOrderPage.runCashValuablesReceptionByOrderProcess(operationDataTO);
        valuesByOrderPaymentPage.clickProceedButton();
        valuesByOrderPaymentPage
                .addPaymentData(operationDataTO)
                .checkMessage(OPERATION_COMPLETE);
    }
}
