import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> destinations = new ArrayList<>();


        Pattern pattern = Pattern.compile("((=|/))(?<destination>[A-Z][A-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            destinations.add(matcher.group("destination"));
        }
        System.out.println("Destinations: "+ String.join(", " ,destinations));
        System.out.println("Travel Points: "+ destinations.toString().replaceAll("[\\[\\], ]", "").length());
    }
}
