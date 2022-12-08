
import java.util.*;

public class TaxCalculator {

    public static void scanTheInput(){
        Scanner input = new Scanner(System.in);
        List<String> lines = new ArrayList<String>();
        String lineNew;

        while (input.hasNextLine()) {
            lineNew = input.nextLine();
            if (lineNew.isEmpty()) {
                break;
            }
            lines.add(lineNew);
        }


        parseInputStringIntoActionableItems(lines);

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

/*Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

 */
