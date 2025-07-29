package factory;

import enums.BusinessProcessName;
import enums.CurrencyKind;
import enums.FinancialType;
import to.CashOperRegisterDataTO;
import to.OperationDataTO;
import to.WorkplaceBalanceDataTO;

public class OperationDataFactory {
    public OperationDataTO createOperationData(double amount, CurrencyKind currencyKind, FinancialType financialType) {
        return new OperationDataTO(amount, currencyKind, financialType);
    }

    public CashOperRegisterDataTO createCashOperRegisterData(double amount, String currencyKind, String businessProcessName, String financialType) {
        return new CashOperRegisterDataTO(amount, currencyKind, businessProcessName, financialType);
    }

}
