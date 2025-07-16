package enums;

public enum CurrencyKind {
    BYN("Белорусский рубль"),
    USD("Доллар США");
    private String currencyKind;

    CurrencyKind(String currencyKind) {
        this.currencyKind = currencyKind;
    }

    public String getCurrencyKind() {
        return currencyKind;
    }
}
