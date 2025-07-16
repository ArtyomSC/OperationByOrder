package dataProvider;

import factory.OperationDataFactory;
import org.testng.annotations.DataProvider;
import to.OperationDataTO;

import static enums.CurrencyKind.*;

public class OperationByOrderProcessData {
    OperationDataFactory operationDataFactory = new OperationDataFactory();
    OperationDataTO operationDataTO;

    @DataProvider(name = "cashValuablesReceptionByOrderProcessData")
    public Object[][] cashValuablesReceptionByOrderProcessData() {
        operationDataTO = operationDataFactory.createOperationData(10, BYN);
        return new Object[][]{
                {operationDataTO}
        };
    }

    @DataProvider(name = "issuanceValuesByOrderProcessData")
    public Object[][] issuanceValuesByOrderProcessData() {
        operationDataTO = operationDataFactory.createOperationData(5, BYN);
        return new Object[][]{
                {operationDataTO}
        };
    }
}