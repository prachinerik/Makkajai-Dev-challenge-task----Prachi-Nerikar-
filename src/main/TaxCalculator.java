package main;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {

    private Invoice invoice;
    public TaxCalculator(Invoice invoice) {
        this.invoice = invoice;
    }
    private List<ProcessedItem> processedItemsList = new ArrayList<>();

    public Tax getSalesTax() {
        double totalSalesTax = 0;
        double totalPrice = 0;
        ProcessedItem processedItem = null;
        for (Item item: this.invoice.getItems())    {
            double salesTaxOnItem = 0;
            double importDutyOnItem = 0;
            double price = item.getPrice() * item.getQuantity();

            if(item.isSalesTaxApplicable())   {
                salesTaxOnItem = price * 0.1;
            }
            if(item.isImportDutyApplicable()) {
                importDutyOnItem = (price + salesTaxOnItem) * .05;
            }

            double priceWithTax = price+salesTaxOnItem+importDutyOnItem;
            processedItem = new ProcessedItem(item, (Math.ceil(priceWithTax*20))/20);
            processedItemsList.add(processedItem);
            totalSalesTax = totalSalesTax + salesTaxOnItem + importDutyOnItem;
            totalPrice = totalPrice + item.getQuantity() * item.getPrice() + salesTaxOnItem + importDutyOnItem;

        }
        Tax tax = new Tax((Math.ceil(totalSalesTax*20))/20,(Math.ceil(totalPrice*20))/20);
        return tax;
    }

    public List<ProcessedItem> getProcessedItemsList()  {
        return processedItemsList;
    }


    public String getFormattedText() {
        StringBuilder stringBuilder = new StringBuilder();
        Tax tax = getSalesTax();
        List<ProcessedItem> processedItemsList = getProcessedItemsList();
        for (ProcessedItem processedItem: processedItemsList) {
            String line =String.format("%d" + " " + "%s" + ": " + "%f", processedItem.getItem().getQuantity(),processedItem.getItem().getName(), processedItem.getPriceWithSalesTax());
            stringBuilder.append(line);
            stringBuilder.append(System.getProperty("line.separator"));
        }
        String salesTaxLine = String.format("Sales Taxes: %f",tax.getSalesTax());
        String totalPrice = String.format("Total: %f",tax.getTotalPrice());
        stringBuilder.append(salesTaxLine);
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(totalPrice);
        stringBuilder.append(System.getProperty("line.separator"));
        return stringBuilder.toString();
    }


}

