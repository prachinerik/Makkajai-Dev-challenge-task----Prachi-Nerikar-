
import java.util.*;

public class TaxCalculator {

    public static void scanTheInput(){
        Scanner input = new Scanner(System.in);
        List<String> inputLines = new ArrayList<String>();
        String lineNew;

        while (input.hasNextLine()) {
            lineNew = input.nextLine();
            if (lineNew.isEmpty()) {
                break;
            }
            inputLines.add(lineNew);
        }
        parseInputStringIntoActionableItems(inputLines);

    }

    public static void parseInputStringIntoActionableItems(List<String> inputList){
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
           calculateTax(inputItemList);
       }
       catch (Exception e){
           System.out.println("Your input is Invalid, Please recheck");
       }

    }


    public static void calculateTax(List<InputItem> inputItemList){
        Map<InputItem, Double> inputItemAndTaxMap = new HashMap<>();
        double salesTax;

        double importDuty;
        // calculating regular sales tax
        for(InputItem input : inputItemList){
            importDuty = 0;
            if(input.name.contains("book") || input.name.contains("chocolate") || input.name.contains("pills")){
                salesTax = 0;
            } else {
                salesTax = input.quantity * input.price * 0.1;

            }
            // calculating import duty on imported goods
            if(input.name.contains("imported")){
                importDuty = (salesTax + input.price)*.05;

            }
            inputItemAndTaxMap.put(input, (Math.ceil((input.price+salesTax+importDuty) * 20))/20);

        }
        createOutPut(inputItemAndTaxMap);
    }

    public static void createOutPut( Map<InputItem, Double> inputItemAndTaxMap){
        double totalPrice = 0;
        double totalSalesTax = 0;
        for (Map.Entry<InputItem, Double> entry : inputItemAndTaxMap.entrySet()){
            System.out.println(entry.getKey().quantity + " "+ entry.getKey().name + " "+ entry.getValue());
            totalSalesTax = totalSalesTax + (entry.getValue() - entry.getKey().price);
            totalPrice = totalPrice + entry.getValue();
        }
        System.out.println( "Sales Tax" + " "+ Math.ceil(totalSalesTax * 20)/20);
        System.out.println( "Total" + " "+ Math.ceil(totalPrice * 20)/20);

    }
    public static void main(String[] args) {
         scanTheInput();
    }
}


