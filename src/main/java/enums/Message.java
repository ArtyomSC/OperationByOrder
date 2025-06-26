package enums;

public enum Message {
    OPERATION_COMPLETE("Операция завершена");
    private String message;

    Message(String message){
    this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
