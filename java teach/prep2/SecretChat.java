package mlc.examprep.prep2;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String command = scanner.nextLine();
        while(!"Reveal".equals(command)) {
            String[] commands = command.split(":\\|:");
            switch (commands[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    message = message.substring(0, index) + " " + message.substring(index);
                    System.out.println(message);
                    break;
                case "Reverse":
                    message = reverse(message, commands[1]);
                    break;
                case "ChangeAll":
                    message = message.replaceAll(commands[1], commands[2]);
                    System.out.println(message);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }

    private  static String reverse(String message, String subString) {
        if(message.contains(subString)) {
            StringBuilder sb = new StringBuilder(subString);
            message = message.replaceFirst(subString, "");
            message = message.concat(sb.reverse().toString());
            System.out.println(message);
        } else {
            System.out.println("error");
        }
        return message;
    }
}
