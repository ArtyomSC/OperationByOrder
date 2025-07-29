package to;

import java.util.Objects;

public class CashOperRegisterDataTO {
    private double sum;
    private String kindName;
    private String businessProcessName;
    private String financialType;

    public CashOperRegisterDataTO(double sum, String kindName, String businessProcessName, String financialType) {
        this.sum = sum;
        this.kindName = kindName;
        this.businessProcessName = businessProcessName;
        this.financialType = financialType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashOperRegisterDataTO that = (CashOperRegisterDataTO) o;
        return Objects.equals(sum, that.sum) && Objects.equals(kindName, that.kindName) && Objects.equals(businessProcessName, that.businessProcessName) && Objects.equals(financialType, that.financialType);
    }
}
