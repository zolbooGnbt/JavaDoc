import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([#@])[A-Za-z]{3,}\\1{2}[A-Za-z]{3,}\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> pairWords = new ArrayList<>();

        while (matcher.find()) {
            pairWords.add(matcher.group());
        }

        List<String> mirrorWords = new ArrayList<>();
        if (pairWords.isEmpty()) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(pairWords.size() + " word pairs found!");
            for (String pairWord : pairWords) {
                String mirrorWord = isMirrorWords((pairWord));
                if (mirrorWord != null) {
                    mirrorWords.add(mirrorWord);
                }
            }
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }

    public static String isMirrorWords(String input) {
        String[] words = input.split("[@#]+");
        StringBuilder sb = new StringBuilder(words[1]);
        return words[2].equals(sb.reverse().toString()) ?
                String.format("%s <=> %s", words[1], words[2]) : null;
    }
}
