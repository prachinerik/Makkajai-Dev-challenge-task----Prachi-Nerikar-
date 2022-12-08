import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputScanner {
    public static List<String> scanTheInput(){
        ParseInputIntoActionableItems parseInputIntoActionableItems = new ParseInputIntoActionableItems();
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
        ParseInputIntoActionableItems.parseInputStringIntoActionableItems(inputLines);
        return inputLines;
    }

    public static void main(String[] args) {
        scanTheInput();
    }
}
