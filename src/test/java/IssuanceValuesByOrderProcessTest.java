import dataProvider.OperationByOrderProcessData;
import org.testng.annotations.Test;
import pages.IssuanceValuesByOrderPage;
import to.OperationDataTO;

import static enums.BusinessProcessName.ISSUANCE_VALUES_BY_ORDER;
import static enums.Message.OPERATION_COMPLETE;

public class IssuanceValuesByOrderProcessTest extends BaseTest {
    private IssuanceValuesByOrderPage issuanceValuesByOrderPage = new IssuanceValuesByOrderPage();

    @Test(dataProvider = "issuanceValuesByOrderProcessData", dataProviderClass = OperationByOrderProcessData.class)
    public void testIssuanceValuesByOrderProcess(OperationDataTO operationDataTO) {
        homePage.openBusinessProcess(ISSUANCE_VALUES_BY_ORDER.getBusinessProcessName());
        issuanceValuesByOrderPage
                .runIssuanceValuesByOrderProcess(operationDataTO)
                .checkMessage(OPERATION_COMPLETE.getMessage());
    }
}