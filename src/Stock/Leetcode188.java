package Stock;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 9:26 PM
 */
public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        //0不操作  1 第一次买入  2 第一次卖出
        int[][] dp = new int[n][2 * k + 1];
        for (int j = 1; j < 2 * k + 1; j += 2) {
            dp[0][j] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[n - 1][2 * k];
    }
}
