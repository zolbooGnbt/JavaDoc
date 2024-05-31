import java.util.ArrayList;
import java.util.Scanner;

public class toDoListTeam3 {
    static String command;
    static ArrayList<String> todoList = new ArrayList<>();
    static Boolean Checked = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            command = sc.nextLine();
            if (command.contains("add")) {
                addTask();
                Checked = true;
            }
            if (command.contains("list")) {
                showList();
                Checked = true;
            }
            if (command.contains("done")) {
                Done();
                Checked = true;
            }
            if (!Checked) {
                System.out.println("Invalid command");
            }
        }
    }

    public static void addTask() {
        String[] itemSplit = command.split("(add)");
        todoList.add(itemSplit[1]);
        System.out.printf("Created task %d.\n", todoList.size());
    }

    public static void showList() {
        System.out.println("ID Description");
        System.out.println("-- -----------");

        for (int j = 0; j < 2; j++) {
            if (todoList.contains("done")) {
                for (int i = 0; i < todoList.size(); i++) {
                    if (todoList.get(i).equals("done")) {
                        todoList.remove(i);
                    }
                }
            }
        }
        for (int j = 0; j < todoList.size(); j++) {
            System.out.println(todoList.indexOf(todoList.get(j)) + 1 + "  " + todoList.get(j));
        }
        System.out.println("task " + todoList.size());
        System.out.println();

    }

    public static void Done() {

        char[] number = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char id : number) {
            if (Character.isDigit(id)) {
                sb.append(id);
                int index = Integer.parseInt(String.valueOf(sb));
                if ((index - 1) < 0 || index > todoList.size()) {
                    System.out.println("Wrong id number! Please enter in range of 1 to " + todoList.size());
                } else {
                    todoList.remove(index - 1);
                }
            }
        }
    }
}
