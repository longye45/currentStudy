package sort;

public class InsertSort {
    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;
        for (int i = 0; i < arr.length; i++) {
            int j;
            int a = arr[i];
            for (j = i; j > 0 && arr[j - 1] > a; j--)
                arr[j] = arr[j - 1];
            arr[j] = a;
        }
        return arr;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 3, 7, 4, 6, 9, 8, 10, 16, 25, 12};
        int[] res = insertSort(arr);
        print(res);
    }
}
