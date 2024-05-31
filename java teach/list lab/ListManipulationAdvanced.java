package mlc.list.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (;;) {
            String commandInput = scanner.nextLine();
            if (commandInput.equals("end"))
                break;
            switch (commandInput.split(" ")[0]) {
                case "Contains":
                    printContains(list, Integer.valueOf(commandInput.split(" ")[1]));
                    break;
                case "Print":
                    if(commandInput.split(" ")[1].equals("even"))
                       printEven(list);
                    else
                        printOdd(list);
                    break;
                case "Get":
                    printSum(list);
                    break;
                case "Filter":
                    printFilter(list, commandInput.split(" ")[1],
                            Integer.valueOf(commandInput.split(" ")[2]));
            }
        }
    }

    public static void printContains(List<Integer> list, int number) {
        if(list.contains(number)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    public static void printEven(List<Integer> list) {
        System.out.println(
                list.stream().filter(x -> x % 2 == 0)
                        .collect(Collectors.toList())
                        .toString().replaceAll("[\\[\\],]", ""));
    }

    public static void printOdd(List<Integer> list) {
        System.out.println(
                list.stream().filter(x -> x % 2 == 1)
                        .collect(Collectors.toList())
                        .toString().replaceAll("[\\[\\],]", ""));
    }

    public static void printSum(List<Integer> list) {
        int sum = 0;
        for(Integer number : list)  {
            sum += number;
        }
        System.out.println(sum);
    }

    public static void printFilter( List<Integer> list, String operator, int value) {
        switch (operator) {
            case "<":
                System.out.println(
                        list.stream().filter(x -> x < value)
                                .collect(Collectors.toList())
                                .toString().replaceAll("[\\[\\],]", ""));
                break;
        case "<=":
            System.out.println(
                    list.stream().filter(x -> x <= value)
                            .collect(Collectors.toList())
                            .toString().replaceAll("[\\[\\],]", ""));
            break;
        case ">":
            System.out.println(
                    list.stream().filter(x -> x > value)
                            .collect(Collectors.toList())
                            .toString().replaceAll("[\\[\\],]", ""));
            break;
        case ">=":
            System.out.println(
                    list.stream().filter(x -> x >= value)
                            .collect(Collectors.toList())
                            .toString().replaceAll("[\\[\\],]", ""));
            break;
        }
    }
}
