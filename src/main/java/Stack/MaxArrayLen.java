package Stack;

/**
 * 最长子数组的O(Nlogn)算法
 */
public class MaxArrayLen {
    public static int[] getdp(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m])
                    l = m + 1;
                else
                    r = m - 1;
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = 1 + l;
        }
        return dp;
    }

    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    public static int[] lis(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        int[] dp = getdp(arr);
        return generateLIS(arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 3, 7, 9, 8};
        int[] res = lis(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
