
import java.util.*;

class CreateOutput {

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

}


