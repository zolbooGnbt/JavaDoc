
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    private String type;
    private String model;
    private String color;
    private int horsepower;

    public VehicleCatalogue(String input) {
        String[] inputs = input.split(" ");
        this.type = inputs[0];
        this.model = inputs[1];
        this.color = inputs[2];
        this.horsepower = Integer.parseInt(inputs[3]);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Type: " + ("car".equals(type) ? "Car": "Truck") + "\n" +
                "Model: " + model + "\n" +
                "Color: " + color + "\n" +
                "Horsepower: " + horsepower;
    }

    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<VehicleCatalogue> vehicles = new ArrayList<>();
        while (!"End".equals(input)) {
            vehicles.add(new VehicleCatalogue(input));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while(!"Close the Catalogue".equals(input)) {
            for (VehicleCatalogue vehicle: vehicles) {
                if (input.equals(vehicle.getModel()))
                    System.out.println(vehicle);
            }
            input = scanner.nextLine();
        }
        int sumCar = 0;
        int countCar = 0;
        int sumTruck = 0;
        int countTruck = 0;
        for (VehicleCatalogue vehicle : vehicles) {
            if ("car".equals(vehicle.getType())) {
                countCar ++;
                sumCar += vehicle.getHorsepower();
            } else {
                countTruck ++;
                sumTruck += vehicle.getHorsepower();
            }
        }

        System.out.printf("Cars have average horsepower of: %.2f.\n", 1.0 * sumCar / (countCar == 0 ? 1 : countCar));
        System.out.printf("Trucks have average horsepower of: %.2f.\n", 1.0 * sumTruck / (countTruck == 0 ? 1: countTruck));
    }
}
