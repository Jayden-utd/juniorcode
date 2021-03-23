/**
 * @Description:
 * @author: Jayden
 * @date:3/19/21 8:01 PM
 */
public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //for the delete action, we have known the edit distance dp[i - 1][j]
                    //so if we want to compute the dp[i][j], we need to delete the last char in string word1
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    //for the insert action, we have known the edit distance dp[i][j - 1]
                    //so if we want to compute the dp[i][j], we need to insert a char in string word1
                    int insert = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(delete, Math.min(replace, insert));
                }
            }
        }
        return dp[m][n];
    }
}
