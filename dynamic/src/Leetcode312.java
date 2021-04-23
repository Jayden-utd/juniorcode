/**
 * @Description:
 * @author: Jayden
 * @date:4/20/21 11:24 AM
 */
public class Leetcode312 {
    public static void main(String[] args) {
        Leetcode312 test = new Leetcode312();
        test.maxCoins(new int[]{1,2,3,4});
    }
    //区间dp 先更新 长度1的 再2的
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] nums2 = new int[length + 2];
        System.arraycopy(nums, 0, nums2, 1, length);
        nums2[0] = 1;
        nums2[length + 1] = 1;
        int[][] dp = new int[nums2.length][nums2.length];
        for (int len = 1; len <= length; ++len) {
            for (int i = 1; i <= length - len + 1; ++i) {
                int j = i + len - 1;
                System.out.println(i + " " + j);
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], nums2[i - 1] * nums2[k] * nums2[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][nums.length];
    }
}
