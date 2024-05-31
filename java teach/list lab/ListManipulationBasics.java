package mlc.list.lab;

    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    public class ListManipulationBasics {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (;;) {
                String commandInput = scanner.nextLine();
                if (commandInput.equals("end"))
                    break;
                switch (commandInput.split(" ")[0]) {
                    case "Add":
                        list.add(Integer.parseInt(commandInput.split(" ")[1]));
                        break;
                    case "Remove":
                        list.remove(Integer.valueOf(commandInput.split(" ")[1]));
                        break;
                    case "RemoveAt":
                        list.remove(Integer.parseInt(commandInput.split(" ")[1]));
                        break;
                    case "Insert":
                        list.add(Integer.parseInt(commandInput.split(" ")[2]),
                                Integer.parseInt(commandInput.split(" ")[1]));
                        break;
                }
            }
            for(Integer number : list)  {
                System.out.print(number + " ");
            }
        }
    }
