package sort;

public class ChooseSort {
    public static void ChooseSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int pos = i;
            int x = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }
            arr[i] = min;
            arr[pos] = x;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 3, 7, 4, 6, 9, 8, 10, 16, 25, 12};
        ChooseSort(arr);
        print(arr);
    }
}
