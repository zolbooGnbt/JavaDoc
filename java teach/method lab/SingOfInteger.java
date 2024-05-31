package mlc.methods.lab;

import java.util.Scanner;

public class SingOfInteger {
    public static void main(String[] args) {
        printSign(new Scanner(System.in).nextInt());
    }

    private static void printSign(int number) {
        if(number > 0)
            System.out.printf("The number %d is positive.", number);
        else
            if(number == 0)
                System.out.printf("The number %d is zero.", number);
            else
                System.out.printf("The number %d is negative.", number);
    }
}
