package mlc.midexam;

import java.util.Scanner;

public class BonusScoringSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = scanner.nextInt();
        int countLectures = scanner.nextInt();
        int bonusPoint = scanner.nextInt();

        double maxBonus = 0;
        int lectureAttendee = 0;

        for(int i = countStudents; i > 0; i--) {
            int courseAttendee = scanner.nextInt();
            double currenPoint = 1.0  * courseAttendee / countLectures * (5 + bonusPoint);
            if(currenPoint > maxBonus) {
                maxBonus = currenPoint;
                lectureAttendee = courseAttendee;
            }
        }

        System.out.printf("Max Bonus: %d.%n", Math.round(maxBonus));
        System.out.printf("The student has attended %d lectures.", lectureAttendee);
    }
}
