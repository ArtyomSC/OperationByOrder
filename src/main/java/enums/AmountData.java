package enums;

public enum AmountData {
    AMOUNT_DATA("10");
    private String amount;

    AmountData(String amount){
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }
}
