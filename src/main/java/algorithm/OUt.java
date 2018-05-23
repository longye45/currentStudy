package algorithm;

/**
 * 二维数组逆序输出
 */
public class OUt {
    public static void getOut(int[][] nums) {

        int i = 0;
        while (i < nums.length / 2 || i < nums[0].length / 2) {
            for (int j = i; j < nums.length - i - 1; j++) {
                System.out.println(nums[j][i]);
            }
            for (int j = i; j < nums[0].length - i - 1; j++) {
                System.out.println(nums[nums.length - i - 1][j]);
            }
            for (int j = nums.length - i - 1; j > i; j--) {
                System.out.println(nums[j][nums[0].length - i - 1]);
            }
            for (int j = nums[0].length - i - 1; j > i; j--) {
                System.out.println(nums[i][j]);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[5][4];
        nums[0] = new int[]{1, 2, 3, 4};
        nums[1] = new int[]{5, 6, 7, 8};
        nums[2] = new int[]{9, 10, 11, 12};
        nums[3] = new int[]{13, 14, 15, 16};
        nums[4] = new int[]{17, 18, 19, 20};
        getOut(nums);
    }
}
