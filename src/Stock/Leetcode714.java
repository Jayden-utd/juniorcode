package Stock;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 10:16 PM
 */
public class Leetcode714 {
    public static void main(String[] args) {
        Leetcode714 test = new Leetcode714();
        System.out.println(test.maxProfit(new int[]{1,4,4,2,9,10}, 2));
    }
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];

            // 情况三：保持原有状态（因为此时买则不便宜，卖则亏本）
            if (prices[i] >= minPrice && prices[i] <= minPrice + fee) {
                continue;
            }

            if (prices[i] > minPrice + fee) {
                result += prices[i] - minPrice - fee;
                // 情况一，这一步很关键
                minPrice = prices[i] - fee;
            }
        }
        return result;
    }

    public int maxProfitdp(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
