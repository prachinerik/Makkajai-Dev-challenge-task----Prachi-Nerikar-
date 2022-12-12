package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemFactory {

    public static Item generateItem(String line) {
        Pattern patternToParseQuantity = Pattern.compile("([0-9]+) ([a-z ]+) at ([0-9]+.[0-9]+)");
        Matcher matchingPattern = patternToParseQuantity.matcher(line);
        String name = "";
        int quantity = 0;
        float price = 0F;
        if (matchingPattern.find()) {
            quantity = Integer.parseInt(matchingPattern.group(1));
            name = matchingPattern.group(2);
            price = Float.parseFloat(matchingPattern.group(3));
        }
        boolean isSalesTaxApplicable = true;
        boolean isImported = false;
        Pattern patternToVerifyIfSalesTaxApplicable = Pattern.compile("(?:chocolate|book|pills)");
        Matcher matcher = patternToVerifyIfSalesTaxApplicable.matcher(name);
        if(matcher.find()){
            isSalesTaxApplicable = false;
        }

        Pattern patternToVerifyIfImported = Pattern.compile("(?:imported)");
        Matcher matcherForIfImported = patternToVerifyIfImported.matcher(name);
        if(matcherForIfImported.find()){
            isImported = true;
        }

        Item item = new Item(quantity, name, price, isSalesTaxApplicable, isImported);
        return item;
    }

}
