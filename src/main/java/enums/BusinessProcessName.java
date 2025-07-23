package enums;

public enum BusinessProcessName {
    CASH_VALUABLES_RECEPTION_BY_ORDER("Прием по документам"),
    ISSUANCE_VALUES_BY_ORDER("Выдача по документам"),
    CASH_OPER_REGISTER("Книга учета принятых и выданных ценностей");
    private String businessProcessName;

    BusinessProcessName(String businessProcess) {
        businessProcessName = businessProcess;
    }

    public String getBusinessProcessName() {
        return businessProcessName;
    }
}
