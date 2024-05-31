package mlc.examprep.prep2;

import mlc.examprep.prep1.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NFS3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (; n > 0; n--) {
            cars.add(new Car(scanner.nextLine()));
        }
        String command = scanner.nextLine();
        while (!"Stop".equals(command)) {
            String[] arr = command.split(" : ");
            switch (arr[0]) {
                case "Drive":
                    cars.stream().filter(car -> car.getName().equals(arr[1]))
                            .forEach(car -> car.drive(Integer.parseInt(arr[2]),
                                    Integer.parseInt(arr[3])));
                    break;
                case "Refuel":
                    cars.stream().filter(car -> car.getName().equals(arr[1]))
                            .forEach(car -> car.refuel(Integer.parseInt(arr[2])));
                    break;
                case "Revert":
                    cars.stream().filter(car -> car.getName().equals(arr[1]))
                            .forEach(car -> car.revert(Integer.parseInt(arr[2])));
                    break;
            }
            command = scanner.nextLine();
        }
        cars.stream().filter(car -> car.getMileage() < 100000)
                .forEach(Car::print);
    }

}
