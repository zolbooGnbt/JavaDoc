package Lab;

import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        int [] num = new int [input.length];

        for (int i = 0; i < input.length; i++) {
            num[i] = Integer.parseInt(input[i]);
        }
        int evenSum = 0;
        int oddSum = 0;
        for (int number : num) {
            if (number % 2 == 0){
                evenSum += number;
            }else {
                oddSum += number;
            }
        }
        System.out.println(evenSum - oddSum);

    }
}
