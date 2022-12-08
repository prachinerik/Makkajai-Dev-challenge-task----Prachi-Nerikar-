import java.util.ArrayList;
import java.util.List;

public class ParseInputIntoActionableItems {
    static CalculateTax calculateTax = new CalculateTax();
    public static List<InputItem> parseInputStringIntoActionableItems(List<String> inputList) {
        UserInputScanner userInputScanner = new UserInputScanner();
        InputItem inputItem;
        List<InputItem> inputItemList = new ArrayList<>();
        try {
            for (String line : inputList) {
                inputItem = new InputItem();
                inputItem.setQuantity(Integer.parseInt(String.valueOf(line.charAt(0))));
                String priceString = line.substring(line.indexOf(" at") + 3, line.length() - 1);
                inputItem.setName(line.substring(1, line.indexOf(" at") + 3));
                inputItem.setPrice(Float.parseFloat(priceString));
                inputItemList.add(inputItem);
            }
            calculateTax.calculateTax(inputItemList);
        }
        catch (Exception e){
            System.out.println("Your input is Invalid, Please recheck");
        }
        return inputItemList;
    }
}
