package factory;

import enums.CurrencyKind;
import enums.FinancialType;
import to.OperationDataTO;

public class OperationDataFactory {
    public OperationDataTO createOperationData(double amount, CurrencyKind currencyKind, FinancialType financialType) {
        return new OperationDataTO(amount, currencyKind, financialType);
    }
}
