import java.util.Scanner;

public class WorldTour {
    public static boolean isValidIndex(String stops ,int index) {
        return index >= 0 && index < stops.length();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            String[] commands = command.split(":");
            switch (commands[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    String string = commands[2];
                    if (isValidIndex(stops, index)) {
                    StringBuilder strBuild = new StringBuilder(stops);
                    strBuild.insert(index, string);
                    stops = strBuild.toString();
                }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    stops =removeSubstring(stops,startIndex,endIndex);
                    System.out.println(stops);
                    break;
                case "Switch":
                    stops = stops.replaceAll(commands[1], commands[2]);
                    System.out.println(stops);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: "+ stops);
    }
    static String removeSubstring(String text, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            startIndex = endIndex;
        }
        String a = text.substring(0, startIndex);
        String b = text.substring(endIndex+1);
        return a+b;
    }
}
