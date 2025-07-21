import dataProvider.OperationByOrderProcessData;
import org.testng.annotations.Test;
import pages.IssuanceValuesByOrderPage;
import pages.ValuesByOrderPaymentPage;
import to.OperationDataTO;

import static enums.BusinessProcessName.ISSUANCE_VALUES_BY_ORDER;
import static enums.Message.OPERATION_COMPLETE;

public class IssuanceValuesByOrderProcessTest extends BaseTest {
    private IssuanceValuesByOrderPage issuanceValuesByOrderPage = new IssuanceValuesByOrderPage();
    private ValuesByOrderPaymentPage valuesByOrderPaymentPage = new ValuesByOrderPaymentPage();

    @Test(dataProvider = "issuanceValuesByOrderProcessData", dataProviderClass = OperationByOrderProcessData.class)
    public void testIssuanceValuesByOrderProcess(OperationDataTO operationDataTO) {
        homePage.openBusinessProcess(ISSUANCE_VALUES_BY_ORDER);
        issuanceValuesByOrderPage.runIssuanceValuesByOrderProcess(operationDataTO);
        valuesByOrderPaymentPage
                .addPaymentData(operationDataTO,ISSUANCE_VALUES_BY_ORDER)
                .checkMessage(OPERATION_COMPLETE);
    }
}