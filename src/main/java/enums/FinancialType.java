package enums;

public enum FinancialType {
    INCOME("приход"),
    OUTCOME("расход");
    private String financialType;

    FinancialType(String financialType) {
        this.financialType = financialType;
    }

    public String getFinancialTypeName() {
        return financialType;
    }
}
