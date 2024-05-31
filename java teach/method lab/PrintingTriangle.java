package mlc.methods.lab;

import java.util.Scanner;

public class PrintingTriangle {

    static void printTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            printLine(1, i);
        }
        for (int i = size - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }

    static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printTriangle(new Scanner(System.in).nextInt());
    }
}
