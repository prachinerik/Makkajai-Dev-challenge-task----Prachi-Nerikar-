package main;

public class Tax {

    private double salesTax;

    private double totalPrice;

    public Tax(double salesTax, double totalPrice) {
        this.salesTax = salesTax;
        this.totalPrice = totalPrice;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getTotalPrice()  {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
