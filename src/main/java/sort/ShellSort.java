package sort;

public class ShellSort {
    public static void shellSort(int[] arr) {
        int dk = arr.length / 2;
        while (dk >= 1) {
            shellInsertSort(arr, dk);
            dk = dk/2;
        }
    }

    public static void shellInsertSort(int[] arr, int dk) {
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int x = arr[i];
                for (j = i - dk; j >= 0 && x < arr[j]; j = j - dk) {
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = x;
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 3, 7, 4, 6, 9, 8, 10, 16, 25, 12};
        shellSort(arr);
        print(arr);
    }
}
