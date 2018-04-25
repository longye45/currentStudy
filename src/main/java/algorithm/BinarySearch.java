package algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * 二分法查找,递归无法简单记录下标
 */
public class BinarySearch {

    private static int count = 0;

    public static int BinarySearch(int finder, List<Integer> sortList) {
//        count++;
//        int size = sortList.size();
//        if (finder == (sortList.get(position = sortList.size() / 2)))
//            return position;
//        if (finder > sortList.get(position)) {
//            return BinarySearch(finder, sortList.subList(size / 2, size));
//        } else
//            return BinarySearch(finder, sortList.subList(0, size / 2));

        int low = 0;
        int high = sortList.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (sortList.get(middle) == finder)
                return middle;
            if (sortList.get(middle) <= finder)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(BinarySearch(8, list));
    }

}
