package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOProcessor {

    public  static List<String> inputLines;

    public static void process()    {

        System.out.println("Please insert the input list");
        Scanner input = new Scanner(System.in);
        inputLines = new ArrayList<String>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputLines.add(line);
        }
        Invoice invoice = InvoiceFactory.get(inputLines);
        TaxCalculator calculator = new TaxCalculator(invoice);

        System.out.println(calculator.getFormattedText());

    }

    public static void main(String[] args) {
        process();
    }
}
