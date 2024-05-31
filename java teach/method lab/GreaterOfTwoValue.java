package mlc.methods.lab;

import java.util.Scanner;

public class GreaterOfTwoValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type) {
            case "int":
                int maxInt = getMax(Integer.parseInt(scanner.nextLine()),
                        Integer.parseInt(scanner.nextLine()));
                System.out.println(maxInt);
                break;
            case "char":
                char maxChar = getMax(scanner.nextLine().charAt(0),
                        scanner.nextLine().charAt(0));
                System.out.println(maxChar);
                break;
            case "string":
                String maxString = getMax(scanner.nextLine(),
                        scanner.nextLine());
                System.out.println(maxString);
                break;
        }
    }

    public static int getMax(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    public static char getMax(char value1, char value2) {
        return value1 > value2 ? value1 : value2;
    }

    public static String getMax(String value1, String value2) {
        return value1.compareTo(value2) >= 0 ? value1 : value2;
    }
}
