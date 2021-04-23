/**
 * @Description:
 * @author: Jayden
 * @date:4/22/21 5:19 PM
 */
public class CountPanlidrome {
    public static void main(String[] args) {
        CountPanlidrome test = new CountPanlidrome();
        System.out.println(test.countSubstrings("tacocdt"));
    }
    //又一个区间dp， 巩固 巩固
    //第二层的 时候，求一个 值 可能是需要 再一次循环得到 也可能能直接得到，这个题 是后者
    public int countPs(String str)
    {
        int N = str.length();

        // create a 2D array to store the count
        // of palindromic subsequence
        int[][] cps = new int[N][N];
        boolean p[][] = new boolean[N][N];
        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++) {
            cps[i][i] = 1;
            p[i][i] = true;
        }
        // palindrome of length 2
        for (int i = 0; i < N - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                p[i][i + 1] = true;
                cps[i][i + 1] = 3;
            } else {
                cps[i][i + 1] = 2;
            }
        }

        // check subsequence of length L is
        // palindrome or not
        for (int L = 3; L <= N; L++) {
            for (int i = 0; i <= N-L; i++) {
                int k = L + i - 1;
                if (str.charAt(i) == str.charAt(k) && p[i + 1][k - 1]) p[i][k] = true;
                if(p[i][k]) {
                    cps[i][k] = cps[i][k - 1] + cps[i + 1][k] + 1 - cps[i + 1][k - 1];
                } else {
                    cps[i][k] = cps[i][k - 1] + cps[i + 1][k] - cps[i + 1][k - 1];
                }
            }
        }
        // return total palindromic subsequence
        return cps[0][N - 1];
    }

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;

        if (n <= 0)
            return 0;

        boolean[][] dp = new boolean[n][n];

        // Base case: single letter substrings
        for (int i = 0; i < n; ++i, ++ans)
            dp[i][i] = true;

        // Base case: double letter substrings
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i + 1] ? 1 : 0);
        }

        // All other cases: substrings of length 3 to n
        for (int len = 3; len <= n; ++len)
            for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                ans += (dp[i][j] ? 1 : 0);
            }

        return ans;
    }

}
