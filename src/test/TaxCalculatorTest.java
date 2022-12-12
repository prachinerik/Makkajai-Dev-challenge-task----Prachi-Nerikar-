package test;

import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TaxCalculatorTest {
    TaxCalculator taxCalculator;
    String expectedOutputString;

    @Before
    public void createItemList(){
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item(1,"imported box of chocolates", 10.00F, false,true);
        Item item2 = new Item(1,"imported bottle of perfume",  47.50F, true,true);
        itemList.add(item1);
        itemList.add(item2);

        Invoice invoice = new Invoice(itemList);
        taxCalculator = new TaxCalculator(invoice);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1 imported box of chocolates: 10.50");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("1 imported bottle of perfume: 54.65");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("Sales Taxes: 7.65");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("Total: 65.15");
        expectedOutputString = stringBuilder.toString();
    }


    @Test
    public void getSalesTaxTestForTotalSalesTax() {
        Tax expectedTax = new Tax(7.9000, 65.4000);
        Tax actualTax = taxCalculator.getSalesTax();
        Assert.assertEquals(actualTax.getSalesTax(), expectedTax.getSalesTax(), 0.05);
    }

    @Test
    public void getSalesTaxTestForTotalPrice() {
        Tax expectedTax = new Tax(7.9000, 65.4000);
        Tax actualTax = taxCalculator.getSalesTax();
        Assert.assertEquals(actualTax.getTotalPrice(), expectedTax.getTotalPrice(), 0.05);
    }

    @Test
    public void getFormattedTextString() {
        Assert.assertEquals(taxCalculator.getFormattedText().split("/n").length,expectedOutputString.split("/n").length);
    }

}
