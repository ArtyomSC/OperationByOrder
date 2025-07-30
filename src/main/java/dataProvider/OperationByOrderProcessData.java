package dataProvider;

import factory.CashOperRegisterDataFactory;
import factory.OperationDataFactory;
import org.testng.annotations.DataProvider;
import to.CashOperRegisterDataTO;
import to.OperationDataTO;

import static enums.BusinessProcessName.CASH_VALUABLES_RECEPTION_BY_ORDER;
import static enums.BusinessProcessName.ISSUANCE_VALUES_BY_ORDER;
import static enums.CurrencyKind.*;
import static enums.FinancialType.INCOME;
import static enums.FinancialType.OUTCOME;

public class OperationByOrderProcessData {
    OperationDataFactory operationDataFactory = new OperationDataFactory();
    CashOperRegisterDataFactory cashOperRegisterDataFactory = new CashOperRegisterDataFactory();
    OperationDataTO operationDataTO;
    CashOperRegisterDataTO cashOperRegisterDataTO;

    @DataProvider(name = "cashValuablesReceptionByOrderProcessData")
    public Object[][] cashValuablesReceptionByOrderProcessData() {
        operationDataTO = operationDataFactory.createOperationData(10, BYN, INCOME);
        cashOperRegisterDataTO = cashOperRegisterDataFactory.createCashOperRegisterData(10, BYN.getCurrencyKindName(),
                CASH_VALUABLES_RECEPTION_BY_ORDER.getBusinessProcessName(), INCOME.getFinancialTypeName());
        return new Object[][]{
                {operationDataTO, cashOperRegisterDataTO}
        };
    }

    @DataProvider(name = "issuanceValuesByOrderProcessData")
    public Object[][] issuanceValuesByOrderProcessData() {
        operationDataTO = operationDataFactory.createOperationData(5, BYN, OUTCOME);
        cashOperRegisterDataTO = cashOperRegisterDataFactory.createCashOperRegisterData(5, BYN.getCurrencyKindName(),
                ISSUANCE_VALUES_BY_ORDER.getBusinessProcessName(), OUTCOME.getFinancialTypeName());
        return new Object[][]{
                {operationDataTO, cashOperRegisterDataTO}
        };
    }
}