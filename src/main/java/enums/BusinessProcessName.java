package enums;

public enum BusinessProcessName {
    CASH_VALUABLES_RECEPTION_BY_ORDER("Прием по документам");
    private String businessProcessName;

    BusinessProcessName(String businessProcess) {
        this.businessProcessName = businessProcess;
    }
    public String getBusinessProcessName(){
        return businessProcessName;
    }
}
