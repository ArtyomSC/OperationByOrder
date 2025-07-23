import dataProvider.OperationByOrderProcessData;
import org.testng.annotations.Test;
import pages.CashOperRegisterPage;
import pages.IssuanceValuesByOrderPage;
import pages.ValuesByOrderPaymentPage;
import pages.WorkplaceBalanceDialogPage;
import to.OperationDataTO;

import java.util.ArrayList;

import static enums.BusinessProcessName.*;
import static enums.Message.OPERATION_COMPLETE;

public class IssuanceValuesByOrderProcessTest extends BaseTest {
    private IssuanceValuesByOrderPage issuanceValuesByOrderPage = new IssuanceValuesByOrderPage();
    private ValuesByOrderPaymentPage valuesByOrderPaymentPage = new ValuesByOrderPaymentPage();
    private CashOperRegisterPage cashOperRegisterPage = new CashOperRegisterPage();
    private WorkplaceBalanceDialogPage workplaceBalanceDialogPage = new WorkplaceBalanceDialogPage();
    private ArrayList<Double> restList = new ArrayList<>();

    @Test(dataProvider = "issuanceValuesByOrderProcessData", dataProviderClass = OperationByOrderProcessData.class)
    public void testIssuanceValuesByOrderProcess(OperationDataTO operationDataTO) {
        restList.add(workplaceBalanceDialogPage.getWorkplaceRest(operationDataTO));
        homePage.openBusinessProcess(ISSUANCE_VALUES_BY_ORDER);
        issuanceValuesByOrderPage.runIssuanceValuesByOrderProcess(operationDataTO);
        valuesByOrderPaymentPage.clickProceedButton();
        homePage.checkMessage(OPERATION_COMPLETE);
        homePage.clearSearch();
        homePage.openBusinessProcess(CASH_OPER_REGISTER);
        cashOperRegisterPage.checkOperation(operationDataTO, ISSUANCE_VALUES_BY_ORDER);
        restList.add(workplaceBalanceDialogPage.getWorkplaceRest(operationDataTO));
        workplaceBalanceDialogPage.checkOutOperationRest(operationDataTO, restList);
    }
}