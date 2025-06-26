package enums;

public enum LoginData {
    BNBSKASS8("bnbskass8", "cash_bnb");
    private String username;
    private String password;

    LoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
