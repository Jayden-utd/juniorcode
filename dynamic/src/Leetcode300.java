import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:4/15/21 9:37 AM
 */
public class Leetcode300 {
    public static void main(String[] args) {
        Leetcode300 test = new Leetcode300();
        System.out.println(test.lengthOfLIS(new int[]{4,2,4,5,3,7}));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res) res = dp[i];
        }
        return res;


    }
}
