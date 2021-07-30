package google;

/**
 * @Description:
 * @author: Jayden
 * @date:7/27/21 5:34 PM
 */
public class Leetcode837 {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0;
        double[] dp = new double[n];
        dp[0] = 1.0;
        double sum = 1.0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = sum / maxPts;
            if (i < k) sum += dp[i];
            if (i - maxPts >= 0) sum -= dp[i - maxPts];
        }
        double res = 0.0;
        for (int i = k; i < dp.length; i++) {
            res += dp[i];
        }
        return res;
    }
}
