package mlc.list.lab;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> mergedList = new LinkedList<>();
        int minSize = Math.min(list1.size(), list2.size());
        for(int i = 0;  i < minSize;i ++) {
            mergedList.add(list1.get(0));
            mergedList.add(list2.get(0));
            list1.remove(0);
            list2.remove(0);
        }
        if(!list1.isEmpty()) {
            mergedList.addAll(list1);
        }
        if(!list2.isEmpty()) {
            mergedList.addAll(list2);
        }
        for(Integer number : mergedList)  {
            System.out.print(number + " ");
        }
    }
}