package factory;

import enums.CurrencyKind;
import to.OperationDataTO;

public class OperationDataFactory {
    //private String amount = "10";

    public OperationDataTO createOperationData(int amount, CurrencyKind currencyKind) {
        return new OperationDataTO(amount, currencyKind);
    }
}
