package Stack;

import java.util.LinkedList;

public class ArraySon {
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);

                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }

                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollLast();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollLast();
            }
            res += j - i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 14, 3, 7, 6};
        System.out.println(getNum(arr, 3));
    }
}
