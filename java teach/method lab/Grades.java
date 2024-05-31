package mlc.methods.lab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        printGrade(new Scanner(System.in).nextDouble());
    }

    public static void printGrade(double grade) {
        if(grade < 3)
            System.out.println("Fail");
        else
        if(grade < 3.5)
            System.out.println("Poor");
        else
        if(grade < 4.5)
            System.out.println("Good");
        else
        if(grade < 5.5)
            System.out.println("Very good");
        else
            System.out.println("Excellent");
    }
}
