import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeedForSpeedIII {
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
                            .forEach(car -> car.Drive(Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
                    break;
                case "Refuel":
                    cars.stream().filter(car -> car.getName().equals(arr[1]))
                            .forEach(car -> car.Refuel(Integer.parseInt(arr[2])));
                    break;
                case "Reveal":
                    cars.stream().filter(car -> car.getName().equals(arr[1]))
                            .forEach(car -> car.Revert(Integer.parseInt(arr[2])));
                    break;
            }
            command = scanner.nextLine();
        }
        cars.stream().filter(car -> car.mileage > 100000).forEach(Car::Print);
    }

    public static class Car {
        private String name;
        private int mileage;

        public Car(String input) {
            String[] inputArray = input.split("\\|");
            this.name = inputArray[0];
            this.mileage = Integer.parseInt(inputArray[1]);
            this.fuel = Integer.parseInt(inputArray[2]);
        }

        public void Drive(int distance, int fuel) {
            if (this.fuel > fuel) {
                System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", this.name, distance, fuel);
            } else {
                System.out.println("Not enough fuel to make that ride");
            }
            if (this.mileage >= 100000) {
                System.out.printf("Time to sell the %s!\n", this.name);
            }
        }

        public void Refuel(int fuel) {
            if (this.fuel + fuel > 75) {
                fuel = 75 - this.fuel;
                this.fuel = 75;
            } else {
                this.fuel += fuel;
            }
            System.out.printf("%s refueled with %d liters\n", this.name, fuel);
        }

        public void Revert(int mileage) {
            if (this.mileage - mileage < 10000)
                this.mileage = 10000;
            else {
                this.mileage -= mileage;
                System.out.printf("%s mileage decreased by %d kilometers\n", this.name, mileage);
            }
        }

        public void Print() {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", this.name, this.mileage, this.fuel);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        private int fuel;
    }
}
