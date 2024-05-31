package mlc.examprep;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        String command = "";
        do {
            command = scanner.nextLine();
            String[] commandArray = command.split(" ");
            switch (commandArray[0]) {
                case "TakeOdd":
                    pass = takeOdd(pass);
                    break;
                case "Cut":
                    pass = cut(pass, Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]));
                    break;
                case "Substitute":
                    pass = substitute(pass, commandArray[1], commandArray[2]);
                    break;
            }

        }while(!"Done".equals(command));
        System.out.printf("Your password is: %s", pass);
    }

    private static String takeOdd(String word) {
        String newWord = "";
        for(int i = 1; i < word.length(); i += 2) {
            newWord += word.charAt(i);
        }
        System.out.println(newWord);
        return newWord;
    }

    private static String cut(String word, int startIndex, int length) {
        String cutWord = word.substring(startIndex, startIndex + length);
        word = word.replaceFirst(cutWord, "");
        System.out.println(word);
        return word;
    }

    private static String substitute(String word, String subStr, String replace) {
        if(word.contains(subStr)) {
            word = word.replaceAll(subStr, replace);
            System.out.println(word);
        } else {
            System.out.println("Nothing to replace!");
        }
        return word;
    }
}
