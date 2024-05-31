package mlc.midexam;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialHealth = 100;
        int initialBitCoins = 0;
        int roomCount = 0;
        boolean isAlive = true;
        String[] rooms = scanner.nextLine().split("\\|");
        for(String room : rooms) {
            roomCount ++;
            String command = room.split(" ")[0];
            int point = Integer.parseInt(room.split(" ")[1]);
            switch(command) {
                case "chest":
                    initialBitCoins += point;
                    System.out.printf("You found %d bitcoins.%n", point);
                    break;
                case "potion":
                    if (initialHealth + point > 100) {
                        point = 100 - initialHealth;
                        initialHealth = 100;
                    } else {
                        initialHealth += point;
                    }
                    System.out.printf("You healed for %d hp.%n", point);
                    System.out.printf("Current health: %d hp.%n", initialHealth);
                    break;
                default:
                    if(initialHealth > point) {
                        initialHealth -= point;
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", roomCount);
                        isAlive = false;
                    }
                    break;
            }
            if (!isAlive) {
                break;
            }
        }
        if(isAlive) {
            System.out.printf("You've made it!%n");
            System.out.printf("Bitcoins: %d%n", initialBitCoins );
            System.out.printf("Health: %d%n", initialHealth);
        }
    }
}
