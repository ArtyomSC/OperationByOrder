package factory;

import enums.CurrencyKind;
import to.OperationDataTO;

public class OperationDataFactory {
    public OperationDataTO createOperationData(int amount, CurrencyKind currencyKind) {
        return new OperationDataTO(amount, currencyKind);
    }
}
