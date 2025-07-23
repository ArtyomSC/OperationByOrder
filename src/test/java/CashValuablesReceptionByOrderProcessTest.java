import dataProvider.OperationByOrderProcessData;
import org.testng.annotations.Test;
import pages.CashOperRegisterPage;
import pages.CashValuablesReceptionByOrderPage;
import pages.ValuesByOrderPaymentPage;
import pages.WorkplaceBalanceDialogPage;
import to.OperationDataTO;

import java.util.ArrayList;

import static enums.BusinessProcessName.CASH_OPER_REGISTER;
import static enums.BusinessProcessName.CASH_VALUABLES_RECEPTION_BY_ORDER;
import static enums.Message.OPERATION_COMPLETE;

public class CashValuablesReceptionByOrderProcessTest extends BaseTest {
    private CashValuablesReceptionByOrderPage cashValuablesReceptionByOrderPage = new CashValuablesReceptionByOrderPage();
    private ValuesByOrderPaymentPage valuesByOrderPaymentPage = new ValuesByOrderPaymentPage();
    private CashOperRegisterPage cashOperRegisterPage = new CashOperRegisterPage();
    private WorkplaceBalanceDialogPage workplaceBalanceDialogPage = new WorkplaceBalanceDialogPage();
    private ArrayList<Double> restList = new ArrayList<>();

    @Test(dataProvider = "cashValuablesReceptionByOrderProcessData", dataProviderClass = OperationByOrderProcessData.class)
    public void testCashValuablesReceptionByOrderProcess(OperationDataTO operationDataTO) {
        restList.add(workplaceBalanceDialogPage.getWorkplaceRest(operationDataTO));
        homePage.openBusinessProcess(CASH_VALUABLES_RECEPTION_BY_ORDER);
        cashValuablesReceptionByOrderPage.runCashValuablesReceptionByOrderProcess(operationDataTO);
        valuesByOrderPaymentPage.clickProceedButton();
        valuesByOrderPaymentPage.addPaymentData(operationDataTO);
        homePage.checkMessage(OPERATION_COMPLETE);
        homePage.clearSearch();
        homePage.openBusinessProcess(CASH_OPER_REGISTER);
        cashOperRegisterPage.checkOperation(operationDataTO, CASH_VALUABLES_RECEPTION_BY_ORDER);
        restList.add(workplaceBalanceDialogPage.getWorkplaceRest(operationDataTO));
        workplaceBalanceDialogPage.checkInOperationRest(operationDataTO, restList);
    }
}
