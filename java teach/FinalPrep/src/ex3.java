import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex3 {
    static class Plants {
        String plantsName;
        int rarity;
        double rating;

        int ratingsRepetitions;

        public void setIndex(int index) {
            this.ratingsRepetitions = index;
        }

        public int getIndex() {
            return ratingsRepetitions;
        }

        public void increaseValueIndex(int amount) {
            this.ratingsRepetitions += amount;
        }

        public void setPlantsName(String plantsName) {
            this.plantsName = plantsName;
        }

        public String getPlantsName() {
            return this.plantsName;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public int getRarity() {
            return this.rarity;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public double getRating() {
            return this.rating;
        }

        public void increaseValue(double amount) {
            this.rating += amount;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        List<Plants> plants = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] plantType = scan.nextLine().split("<->");
            Plants currentPlant = new Plants();
            currentPlant.setPlantsName(plantType[0]);
            currentPlant.setRarity(Integer.parseInt(plantType[1]));

            if (plants.isEmpty()) {
                plants.add(currentPlant);
                continue;
            }

            int index = 0;
            for (Plants existingPlant : plants) {
                if (existingPlant.getPlantsName().equals(plantType[0])) {
                    existingPlant.setRarity(Integer.parseInt(plantType[1]));
                    index += 1;
                    break;
                }
            }

            if (index > 0) {
                index = 0;
            } else {
                plants.add(currentPlant);
            }
        }

        String commands = scan.nextLine();

        while (!commands.equals("Exhibition")) {

            String[] commandParts = commands.split(" - ");

            String commandName = commandParts[0];

            String commandType = commandName.split(" ")[0];

            int index = 0;


            for (Plants currentPlant2 : plants) {
                if (currentPlant2.getPlantsName().equals(commandName.split(": ")[1])) {
                    index += 1;
                }
            }
            if (index == 0) {
                System.out.println("error");
            }

            switch (commandType) {
                case "Rate:":

                    int index2 = 0;

                    for (Plants plant2 : plants) {
                        if (plant2.getPlantsName().equals(commandName.split(": ")[1])) {

                            plant2.increaseValueIndex(1);

                            if (plant2.getRating() > 0 && plant2.getIndex() > 1) {
                                plant2.increaseValue(Integer.parseInt(commandParts[1]));
                                plant2.rating = plant2.rating / 2;
                            } else {
                                plant2.setRating(Double.parseDouble(commandParts[1]));
                            }
                        }
                    }
                    break;

                case "Update:":

                    for (Plants plant2 : plants) {
                        if (plant2.getPlantsName().equals(commandName.split(": ")[1])) {
                            plant2.setRarity(Integer.parseInt(commandParts[1]));
                        }
                    }

                    break;

                case "Reset:":
                    String name3 = commandName.split(": ")[1];
                    for (Plants plant2 : plants) {
                        if (plant2.getPlantsName().equals(name3)){
                            plant2.setRating(0);
                        }
                    }
                    break;
                default:
                    System.out.println("error");
            }
            commands = scan.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        for (Plants plant2 : plants) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant2.getPlantsName(), plant2.getRarity(), plant2.getRating());
        }
    }
}
