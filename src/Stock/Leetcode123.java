package Stock;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 8:22 PM
 */
public class Leetcode123 {
    //at most 2 transactions
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //0不操作  1 第一次买入  2 第一次卖出
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < n; i++) {
            //dp[i][0] = dp[i - 1][0];

            //操作一：第i天买入股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
            //操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

            //操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
            //操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);


            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);


            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[n - 1][4];
    }
}
