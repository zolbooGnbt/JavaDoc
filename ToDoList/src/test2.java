import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    private static List<String> currentList = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (true) {
            if (command.contains("add")) {
                String[] itemSplit = command.split(" ",3);
                currentList.add(itemSplit[2]);
                System.out.printf("Created task %d.", currentList.size());

            } else if (command.contains("list")) {
                showList();

            } else if (command.contains("done")) {

                char[] number = command.toCharArray();
                StringBuilder sb = new StringBuilder();
                for(char id : number){
                    if(Character.isDigit(id)){
                        sb.append(id);
                        int index= Integer.parseInt(String.valueOf(sb));
                        if ((index - 1) < 0 || index > currentList.size()) {
                            System.out.println("Wrong id number! Please enter in range of 1 to " + currentList.size());
                        } else {
                            currentList.remove(index - 1);
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
    }

    public static void showList() {
        System.out.println();
        System.out.println("ID Description");
        System.out.println("-- -----------");
        int id = 0;
        for (String item : currentList) {
            System.out.println(++id + " " + item);
        }
        System.out.println();
        if (id <= 1)
            System.out.println(id + " task.");
        else
            System.out.println(id + " tasks.");
    }

    public  static void addTask(){

    }
}
