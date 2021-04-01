/**
 * @Description:
 * @author: Jayden
 * @date:3/31/21 6:57 PM
 */

//of course the intuitive idea is to use the dfs.
//1. define  2. initial  3. find transformation

public class Leetcode1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        if (length < d)
            return -1;
        //dp[i][j] 表示前 i 天 完成 前 j 项工作的花费的最小难度 i >= j
        int[][] dp = new int[d][length];
        int jobD = 0;
        for (int i = 0; i < length; i++) {
            jobD = Math.max(jobD, jobDifficulty[i]);
            dp[0][i] = jobD;
        }
        for (int k = 1; k < d; k++) {
            for (int num = k; num < jobDifficulty.length; num++) {
                dp[k][num] = Integer.MAX_VALUE;
                int temp = 0;
                for (int i = num; i >= k; i--) {
                    temp = Math.max(temp, jobDifficulty[i]);
                    //ex: 3days finish 10 jobs. [3][10] = [3][8] + previous 2 jobs
                    dp[k][num] = Math.min(dp[k][num], temp + dp[k - 1][i - 1]);
                }
            }
        }
        return dp[d-1][jobDifficulty.length-1];
    }
}
