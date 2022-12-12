package main;

public class ProcessedItem {
    private Item item;
    private double priceWithSalesTax;

    public ProcessedItem(Item item, double priceWithSalesTax) {
        this.item = item;
        this.priceWithSalesTax = priceWithSalesTax;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getPriceWithSalesTax() {
        return priceWithSalesTax;
    }

    public void setPriceWithSalesTax(double priceWithSalesTax) {
        this.priceWithSalesTax = priceWithSalesTax;
    }
}
