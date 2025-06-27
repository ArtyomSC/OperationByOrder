package dataProvider;

import factory.OperationDataFactory;
import org.testng.annotations.DataProvider;
import to.OperationDataTO;

import static enums.BusinessProcessName.CASH_VALUABLES_RECEPTION_BY_ORDER;
import static enums.CurrencyKind.*;
import static enums.Message.OPERATION_COMPLETE;


public class CashValuablesReceptionByOrderProcessData {
    OperationDataFactory operationDataFactory;
    OperationDataTO operationDataTO;

    @DataProvider(name = "cashValuablesReceptionByOrderProcessData")
    public Object[][] cashValuablesReceptionByOrderProcessData() {
        operationDataFactory = new OperationDataFactory();
        operationDataTO = operationDataFactory.createOperationData(10, BYN);
        return new Object[][]{
                {
                        OPERATION_COMPLETE,
                        CASH_VALUABLES_RECEPTION_BY_ORDER,
                        operationDataTO}
        };
    }
}