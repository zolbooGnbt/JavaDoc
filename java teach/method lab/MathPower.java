package mlc.methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(new DecimalFormat("0.####").format((power(Double.parseDouble(scanner.nextLine()), Integer.parseInt(scanner.nextLine())))));
    }

    public static double power(double num, int power) {
        double result = 1;
        for(; power > 0; power --)
            result *= num;
        return  result;
    }
}