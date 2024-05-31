package mlc.midexam;

import java.util.*;

public class TestString {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        print(list);
        list.remove(Integer.valueOf(2));
        print(list);
        list.set(2, 5);
        print(list);
        list.add(2,4);
        print(list);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        print(set);
    }

    private static void print(List<Integer> list) {
        System.out.println(list.toString());
    }

    private static void print(Set<Integer> list) {
        System.out.println(list.toString());
    }
}
