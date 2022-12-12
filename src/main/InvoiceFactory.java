package main;

import java.util.ArrayList;
import java.util.List;

public class InvoiceFactory {
    public static Invoice get(List<String> inputLines) {
        List<Item> itemList = new ArrayList<>();
        for (String line : inputLines) {
            Item item =  ItemFactory.generateItem(line);
            itemList.add(item);
        }
        return new Invoice(itemList);
    }


}
