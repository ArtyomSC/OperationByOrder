package to;

import enums.CurrencyKind;

public class OperationDataTO {
    private int amount;
    private CurrencyKind currencyKind;

    public OperationDataTO(int amount, CurrencyKind currencyKind) {
        this.amount = amount;
        this.currencyKind = currencyKind;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrencyKindName() {
        return currencyKind.getCurrencyKindName();
    }
    public String getCurrencyKindCode() {
        return currencyKind.getCurrencyKindCode();
    }
}
