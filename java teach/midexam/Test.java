package mlc.midexam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        while (true) {
            String input = scanner.nextLine();
            if("Craft!".equals(input))
                break;
            String command = input.split(" - ")[0];
            String item = input.split(" - ")[1];

            switch (command) {
                case "Collect":
                    if(!isExists(inventory, item)) {
                        inventory.add(item);
                    }
                    break;
                case "Drop":
                    inventory.remove(item);
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if(isExists(inventory, oldItem)) {
                        inventory.add(inventory.indexOf(oldItem) + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (isExists(inventory, item)) {
                        inventory.remove(item);
                        inventory.add(item);
                    }
                    break;
            }
        }
        System.out.println(inventory.toString()
                .replaceAll("(abcd)", ""));
        System.out.println(inventory.stream().
                collect(Collectors.joining(", ")));
    }

    private static boolean isExists(List<String> list, String item) {
        return list.contains(item);
    }

    private void printTest() {
        System.out.println("Called print method");
    }
}
