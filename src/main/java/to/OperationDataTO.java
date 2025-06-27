package to;

public class OperationDataTO {
    private String amount;
    private String currencyKind;

    public OperationDataTO(String amount, String currencyKind) {
        this.amount = amount;
        this.currencyKind = currencyKind;
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrencyKind() {
        return currencyKind;
    }
}
