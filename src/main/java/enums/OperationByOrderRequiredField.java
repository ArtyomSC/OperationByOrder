package enums;

public enum OperationByOrderRequiredField {
    CATEGORY("Категория"),
    KIND("Вид"),
    AMOUNT_BY_DOCUMENT("Сумма по документу"),
    AMOUNT_RECEIPT("Сумма к приему"),
    AMOUNT_ISSUE("Сумма к выдаче");
    private String requiredField;

    OperationByOrderRequiredField(String requiredField){
        this.requiredField = requiredField;
    }

    public String getRequiredField(){
        return requiredField;
    }
}
