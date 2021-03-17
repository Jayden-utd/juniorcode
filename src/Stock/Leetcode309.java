package Stock;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 9:56 PM
 */
public class Leetcode309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //0 不持有股票（能购买）的最多现金
        //1 持有股票后的最多现金
        //2 不持有股票（冷冻期）的最多现金
        int[][] dp = new int[n][3];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}

//不持有股票（能购买）的最多现金，是上一个状态卖出了股票在冷冻期，即:dp[i - 1][2]，或者是上一个状态是不持有股票（能购买）即:dp[i - 1][1]，所以：
//dp[i][0] = max(dp[i - 1][0], dp[i - 1][2]);

//持有股票后的最多现金，一定是前一个状态买入了，所以：

//dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

//不持有股票（冷冻期）的最多现金，那么上一个状态一定是卖出股票即：dp[i - 1][0] + prices[i] ，所以
//
//dp[i][2] = dp[i - 1][0] + prices[i];
