package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChooseSort {

    private static int pos = 0;

    private static int chooseMin(List<Integer> arr) {
        int min = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (min > arr.get(i)) {
                min = arr.get(i);
                pos = i;
            }
        }
        return min;
    }

    public static List<Integer> chooseSort(List<Integer> arr) {
        List<Integer> newArr = new LinkedList<>();
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            newArr.add(chooseMin(arr));
            arr.remove(pos);
        }
        return newArr;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(34);
        list.add(45);
        list.add(67);
        list = chooseSort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
