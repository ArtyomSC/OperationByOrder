package enums;

public enum CurrencyKind {
    BYN("Белорусский рубль","BYN"),
    USD("Доллар США","USD");
    private String currencyKindName;
    private String currencyKindCode;

    CurrencyKind(String currencyKind,String currencyKindCode) {
        this.currencyKindName = currencyKind;
        this.currencyKindCode = currencyKindCode;
    }

    public String getCurrencyKindName() {
        return currencyKindName;
    }
    public String getCurrencyKindCode() {
        return currencyKindCode;
    }
}
