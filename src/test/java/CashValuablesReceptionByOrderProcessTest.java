import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static enums.AmountData.AMOUNT_DATA;
import static enums.BusinessProcessName.*;
import static enums.Message.OPERATION_COMPLETE;

public class CashValuablesReceptionByOrderProcessTest extends BaseTest {

    @Test(dataProvider = "cashValuablesReceptionByOrderProcessData")
    public void testCashValuablesReceptionByOrderProcess(String message, String businessProcessName, String amount) {
        Assertions.assertEquals(message,
                homePage.openBusinessProcess(businessProcessName)
                        .runCashValuablesReceptionByOrderProcess(amount)
                        .getMessage());
    }

    @DataProvider(name = "cashValuablesReceptionByOrderProcessData")
    public Object[][] cashValuablesReceptionByOrderProcessData() {
        return new Object[][]{
                {
                    OPERATION_COMPLETE.getMessage(),
                    CASH_VALUABLES_RECEPTION_BY_ORDER.getBusinessProcessName(),
                    AMOUNT_DATA.getAmount()},
        };
    }
}
