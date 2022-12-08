import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateTax {

    static CreateOutput createOutPut = new CreateOutput();
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
        createOutPut.createOutPut(inputItemAndTaxMap);
    }
}
