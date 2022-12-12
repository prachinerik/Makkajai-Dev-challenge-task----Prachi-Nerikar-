package main;

public class Item {

    private final int quantity;
    private final String name;
    private final float price;

    private boolean isSalesTaxApplicable;

    private boolean isImportDutyApplicable;

    public Item(int quantity, String name, float price, boolean isSalesTaxApplicable, boolean isImportDutyApplicable) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.isSalesTaxApplicable = isSalesTaxApplicable;
        this.isImportDutyApplicable = isImportDutyApplicable;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean isSalesTaxApplicable() {
        return isSalesTaxApplicable;
    }

    public boolean isImportDutyApplicable() {
        return isImportDutyApplicable;
    }
}
