package Stock;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 8:22 PM
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //0 不持有 1持有
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }


    public static int[] maxProfitPrint(int[] prices) {
        int[] res = new int[3];
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < buy) {
                buy = price;
                res[0] = i;
            }
            if (price - buy > profit) {
                res[1] = i;
                res[2] = price - buy;
                profit = price - buy;
            }
        }
        return res;
    }
}
