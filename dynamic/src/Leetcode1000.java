/**
 * @Description:
 * @author: Jayden
 * @date:4/21/21 3:38 PM
 */
public class Leetcode1000 {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int len = K; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                //目标就是要更新区间 [i, j] 的dp值，先初始化为整型最大值
                dp[i][j] = Integer.MAX_VALUE;
                //要求区间 [i, j] 的 dp 值，没法直接得到，但是由于是从小区间开始更新的，
                // 所以 suppose 其中的小区间的 dp 值都已经更新好了，就可以将大区间拆成两个小区间来更新了
                for (int t = i; t < j; t += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][t] + dp[t + 1][j]);
                }
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
