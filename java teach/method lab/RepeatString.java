package mlc.methods.lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(repeat(scanner.nextLine(), Integer.parseInt(scanner.nextLine())));
    }

    public static String repeat(String str, int count) {
        String result = "";
        for(; count > 0; count --)
            result += str;
        return  result;
    }
}
