package to;

import enums.CurrencyKind;
import enums.FinancialType;

public class OperationDataTO {
    private double amount;
    private CurrencyKind currencyKind;
    private FinancialType financialType;

    public OperationDataTO(double amount, CurrencyKind currencyKind, FinancialType financialType) {
        this.amount = amount;
        this.currencyKind = currencyKind;
        this.financialType = financialType;
    }

    public double getAmount() {
        return amount;
    }

    public FinancialType getFinancialType() {
        return financialType;
    }

    public CurrencyKind getCurrencyKind() {
        return currencyKind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationDataTO that = (OperationDataTO) o;
        return Double.compare(amount, that.amount) == 0 && currencyKind == that.currencyKind && financialType == that.financialType;
    }
}
