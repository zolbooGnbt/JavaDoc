import java.util.ArrayList;
import java.util.Scanner;

public class test1 {
    static String command, toDO;
    static ArrayList<String> my_toDo = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuItem = -1;

        while (menuItem != 0) {
            menuItem = menu();

            switch (menuItem) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showList();
                    break;
                case 3:
                    doneTask();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
        }
    }

    public static int menu() {
        int choice;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Todo List Menu");
        System.out.println("--------------");
        System.out.println("1. Add task to list");
        System.out.println("2. Show all task");
        System.out.println("3. Done task from list");
        System.out.println("4. All task history");
        System.out.print("Enter choice: ");
        choice = keyboard.nextInt();

        return choice;
    }

    public static String addTask() {
        Scanner input = new Scanner(System.in);
        System.out.print("Task add ");
        String item = input.next();
        System.out.println(item);
        System.out.println();
        return null;
    }

    public static String showList() {
        System.out.println("ID Description");
        System.out.println("-- -----------");
        int id = 0;
        for (String item : my_toDo) {
            System.out.println(++id + " " + item);
        }
        System.out.println();
        if (id <= 1)
            System.out.println(id + " task.");
        else
            System.out.println(id + " tasks.");
        return null;
    }

    public static void doneTask() {
        char[] number = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char id : number) {
            if (Character.isDigit(id)) {
                sb.append(id);
                int index = Integer.parseInt(String.valueOf(sb));
                if ((index - 1) < 0 || index > my_toDo.size()) {
                    System.out.println("Wrong id number! Please enter in range of 1 to " + my_toDo.size());
                } else {
                    my_toDo.remove(index - 1);
                }
            }
        }
    }
}
