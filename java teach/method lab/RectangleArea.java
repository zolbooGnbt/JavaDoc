package mlc.methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new DecimalFormat("0.##").format(calcArea(scanner.nextDouble(), scanner.nextDouble())));
    }

    public static double calcArea(double width, double height) {
        return  height * width;
    }
}
