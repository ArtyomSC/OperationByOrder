package to;

import java.util.Objects;

public class WorkplaceBalanceDataTO {
    private double rest;
    private String currencyKindName;

    public WorkplaceBalanceDataTO(double rest, String currencyKind) {
        this.rest = rest;
        this.currencyKindName = currencyKind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkplaceBalanceDataTO that = (WorkplaceBalanceDataTO) o;
        return Double.compare(rest, that.rest) == 0 && Objects.equals(currencyKindName, that.currencyKindName);
    }

    public void setRest(double rest) {
        this.rest = rest;
    }

    public double getRest() {
        return rest;
    }

    public String getCurrencyKindName() {
        return currencyKindName;
    }
}