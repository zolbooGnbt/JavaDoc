import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderByAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while(!"End".equals(input)) {
            people.add(new Person(input));
            input = scanner.nextLine();
        }
        people = people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        for (Person person: people) {
            System.out.println(person);
        }
    }

    private static class Person {
        private String name;
        private String id;
        private int age;

        public Person(String input) {
            String[] inputs = input.split(" ");
            this.name = inputs[0];
            this.id = inputs[1];
            this.age = Integer.parseInt(inputs[2]);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", name, id, age);
        }
    }
}
