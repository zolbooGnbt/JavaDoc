package mlc.midexam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String  input = scanner.nextLine();
        while (!"Craft!".equals(input)) {
            String command = input.split(" - ")[0];
            String item = input.split(" - ")[1];
            switch (command) {
                case "Collect":
                    if(!items.contains(item)) {
                        items.add(item);
                    }
                    break;
                case "Drop":
                    items.remove(item);
                    break;
                case "Combine Items":
                    String item1 = item.split(":")[0];
                    String item2 = item.split(":")[1];
                    if(items.contains(item1)) {
                        items.add(items.indexOf(item1) + 1, item2);
                    }
                    break;
                case "Renew":
                    if(items.contains(item)) {
                        items.remove(item);
                        items.add(item);
                    }
                    break;
                default: break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", items));
    }

    private static void print(List<String> list) {
        System.out.println(String.join(", ", list));
    }
}



