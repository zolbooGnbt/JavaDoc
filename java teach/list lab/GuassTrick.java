package mlc.list.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GuassTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int middle = list.size() / 2;
        for(int i = 0; i < middle; i ++) {
            list.set(i, list.get(i) + list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        for(Integer number : list)  {
            System.out.print(number + " ");
        }
    }
}
