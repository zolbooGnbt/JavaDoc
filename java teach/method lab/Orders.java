package mlc.methods.lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity  = Integer.parseInt(scanner.nextLine());
        double total = getTotalPrice(product, quantity);
        System.out.printf("%.2f",total);
    }

    private static double getTotalPrice(String producct, int quantity) {
        switch (producct) {
            case "coffee": return 1.5 * quantity;
            case "water": return 1.0 * quantity;
            case "coke": return 1.4 * quantity;
            case "snacks": return 2.0 * quantity;
        }
        return 0;
    }
}
