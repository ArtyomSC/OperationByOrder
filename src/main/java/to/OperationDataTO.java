package to;

import enums.CurrencyKind;

public class OperationDataTO {
    private int amount;
    private CurrencyKind currencyKind;

    public OperationDataTO(int amount, CurrencyKind currencyKind) {
        this.amount = amount;
        this.currencyKind = currencyKind;
    }

    public double getAmount() {
        return amount;
    }

    public CurrencyKind getCurrencyKind() {
        return currencyKind;
    }

}
