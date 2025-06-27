import dataProvider.CashValuablesReceptionByOrderProcessData;
import enums.BusinessProcessName;
import enums.Message;
import org.testng.annotations.Test;
import to.OperationDataTO;

public class CashValuablesReceptionByOrderProcessTest extends BaseTest {
    private String expectedMessage;

    @Test(dataProvider = "cashValuablesReceptionByOrderProcessData", dataProviderClass = CashValuablesReceptionByOrderProcessData.class)
    public void testCashValuablesReceptionByOrderProcess(Message message, BusinessProcessName businessProcessName, OperationDataTO operationDataTO) {
        expectedMessage = homePage
                .openBusinessProcess(businessProcessName)
                .runCashValuablesReceptionByOrderProcess(operationDataTO)
                .getMessage();
        homePage.checkMessage(message, expectedMessage);
    }
}
