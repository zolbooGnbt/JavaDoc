import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {

    private String name;
    private int age;

    public OpinionPoll(String input) {
        this.name = input.split(" ")[0];
        this.age = Integer.parseInt(input.split(" ")[1]);
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<OpinionPoll> people = new ArrayList<>();
        for(;count > 0; count --) {
            people.add(new OpinionPoll(scanner.nextLine()));
        }

        for (OpinionPoll person: people) {
            if(person.getAge() > 30) {
                System.out.println(person);
            }
        }
    }
}
