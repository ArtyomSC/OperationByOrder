import dataProvider.OperationByOrderProcessData;
import org.testng.annotations.Test;
import pages.CashOperRegisterPage;
import pages.IssuanceValuesByOrderPage;
import pages.ValuesByOrderPaymentPage;
import pages.WorkplaceBalanceDialogPage;
import to.CashOperRegisterDataTO;
import to.OperationDataTO;
import to.WorkplaceBalanceDataTO;

import java.util.ArrayList;
import java.util.List;

import static enums.BusinessProcessName.*;
import static enums.Message.OPERATION_COMPLETE;

public class IssuanceValuesByOrderProcessTest extends BaseTest {
    private IssuanceValuesByOrderPage issuanceValuesByOrderPage = new IssuanceValuesByOrderPage();
    private ValuesByOrderPaymentPage valuesByOrderPaymentPage = new ValuesByOrderPaymentPage();
    private CashOperRegisterPage cashOperRegisterPage = new CashOperRegisterPage();
    private WorkplaceBalanceDialogPage workplaceBalanceDialogPage = new WorkplaceBalanceDialogPage();
    private List<WorkplaceBalanceDataTO> restListDefault = new ArrayList<>();

    @Test(dataProvider = "issuanceValuesByOrderProcessData", dataProviderClass = OperationByOrderProcessData.class)
    public void testIssuanceValuesByOrderProcess(OperationDataTO operationDataTO, CashOperRegisterDataTO cashOperRegisterDataTO) {
        restListDefault = workplaceBalanceDialogPage.getWorkplaceRestList();
        homePage.openBusinessProcess(ISSUANCE_VALUES_BY_ORDER);
        issuanceValuesByOrderPage.runIssuanceValuesByOrderProcess(operationDataTO);
        valuesByOrderPaymentPage.clickProceedButton();
        homePage.checkMessage(OPERATION_COMPLETE);
        homePage.clearSearch();
        homePage.openBusinessProcess(CASH_OPER_REGISTER);
        cashOperRegisterPage.checkOperation(cashOperRegisterDataTO);
        workplaceBalanceDialogPage.checkOperationRest(restListDefault, operationDataTO);
    }
}