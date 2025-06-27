import factory.OperationDataFactory;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import to.OperationDataTO;

import static enums.BusinessProcessName.*;
import static enums.Message.OPERATION_COMPLETE;

public class CashValuablesReceptionByOrderProcessTest extends BaseTest {

    @Test(dataProvider = "cashValuablesReceptionByOrderProcessData")
    public void testCashValuablesReceptionByOrderProcess(String message, String businessProcessName, OperationDataTO operationDataTO) {
        Assertions.assertEquals(message,
                homePage.openBusinessProcess(businessProcessName)
                        .runCashValuablesReceptionByOrderProcess(operationDataTO.getAmount())
                        .getMessage());
    }

    @DataProvider(name = "cashValuablesReceptionByOrderProcessData")
    public Object[][] cashValuablesReceptionByOrderProcessData() {
        OperationDataFactory operationDataFactory = new OperationDataFactory();
        OperationDataTO operationDataTO = operationDataFactory.createOperationData();
        return new Object[][]{
                {
                        OPERATION_COMPLETE.getMessage(),
                        CASH_VALUABLES_RECEPTION_BY_ORDER.getBusinessProcessName(),
                        operationDataTO},
        };
    }
}
