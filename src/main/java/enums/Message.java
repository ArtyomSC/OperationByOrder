package enums;

public enum Message {
    OPERATION_COMPLETE("Операция завершена"),
    NULL_AMOUNT_ERROR("Значение должно быть больше нуля"),
    RECEIVED_AMOUNT_ERROR("Введена неверная сумма в поле \"Получено\" для валюты BYN"),
    REQUIRED_FIELD_ERROR("Поле - обязательно для ввода");
    private String message;

    Message(String message){
    this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
