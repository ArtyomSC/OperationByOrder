import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CashValuablesReceptionByOrderProcessTest extends BaseTest {
    @Test
    public void testCashValuablesReceptionByOrderProcess() {
        Assertions.assertEquals("Операция завершена",
                loginPage.loginIntoHomePage("bnbskass8", "cash_bnb")
                        .openBusinessProcess("Прием по документам")
                        .runCashValuablesReceptionByOrderProcess("10")
                        .getMessage());
    }
}
