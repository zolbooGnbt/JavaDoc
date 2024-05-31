
import java.util.Scanner;


public class PasswordReset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string= sc.nextLine();
        char[] password = new char[string.length()];
        String input = sc.nextLine();
        String newPassword="";
        while (!input.equals("Done")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "TakeOdd":
                    for (int i = 1; i < string.length(); i += 2) {
                        newPassword += string.charAt(i);
                    }

                    string = newPassword;

                    System.out.println(string);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);

                    String firstPart = string.substring(0, index);
                    String secondPart = string.substring(index + length);

                    string = firstPart + secondPart;

                    System.out.println(string);
                    break;
                case "Substitute": {
                    String searchFor = command[1];
                    String replaceWith = command[2];
                    String temporary = "";

                    if (string.contains(String.valueOf(searchFor))) {


                        temporary = string.replaceAll(searchFor, replaceWith);
                        string = temporary;

                        System.out.println(string);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                }
            }
            input = sc.nextLine();
        }
        System.out.println("Your password is:" + " " + string);
    }
}
