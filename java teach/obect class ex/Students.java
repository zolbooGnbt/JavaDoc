import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Students {

    private String firstName;
    private String lastName;
    private double grade;

    public Students(String input) {
        String[] inputs = input.split(" ");
        this.firstName = inputs[0];
        this.lastName = inputs[1];
        this.grade = Double.parseDouble(inputs[2]);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", firstName, lastName, grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Students> studentsList = new ArrayList<>();
        for (; count > 0; count --) {
            studentsList.add(new Students(scanner.nextLine()));
        }

        studentsList = studentsList.stream().sorted(Comparator.comparing(Students::getGrade).reversed()).collect(Collectors.toList());
        for (Students student: studentsList) {
            System.out.println(student);
        }
    }
}
