import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

    private static String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
    private static String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
    private static String[] authors = {"Diana", "Mary", "Linda", "Susan", "Sarah", "Lisa", "Annie", "Emily"};
    private static String[] cities = {"London", "Rome", "New York", "Paris", "Berlin"};

    private static void printRandom() {
        Random random = new Random();
        String randomPhrase = phrases[random.nextInt(phrases.length)];
        String randomEvent = events[random.nextInt(events.length)];
        String randomAuthor = authors[random.nextInt(authors.length)];
        String randomCity = cities[random.nextInt(cities.length)];

        System.out.printf("%s %s %s – %s.\n", randomPhrase, randomEvent, randomAuthor, randomCity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for(; count > 0; count --) {
            printRandom();
        }
    }
}
