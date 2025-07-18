package enums;

public enum Category {
    CASH("Денежная наличность");
    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
