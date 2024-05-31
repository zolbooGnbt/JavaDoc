package mlc.methods.lab;

import java.util.Scanner;

public class MultplyEvenOrOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sumEven = sumDigit(Math.abs(number), 0);
        int sumOdd = sumDigit(Math.abs(number), 1);
        System.out.println(sumEven * sumOdd);
    }

    private static int sumDigit(int number, int checkFlag) {
        int sum = 0;
        while(number > 0 ) {
            if(number % 2 == checkFlag)
                sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
