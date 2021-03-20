/**
 * @Description:
 * @author: Jayden
 * @date:3/19/21 11:19 AM
 */
public class Leetcode10 {
    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*"));
    }
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) ) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }











//    public static boolean isMatch(String s, String p) {
//        return dfs(s, p);
//    }
//
//    private static boolean dfs(String s, String p) {
//        if(p.isEmpty()) {
//            return s.isEmpty();
//        }
//        //检查s[0]和p[0]是否匹配
//        boolean isFirstMath = s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
//        //检查模式串的下个字符是否为"*
//        boolean isMatchAny = p.length() > 1 && p.charAt(1) == '*';
//        if(isMatchAny) {
//            //如果包含"*"，可以忽略掉当前字符+*
//            //也可以忽略掉字符串中的当前字符(如果能匹配上)
//            return dfs(s, p.substring(2)) || (isFirstMath && dfs(s.substring(1), p));
//        }
//        else {
//            //单个字符匹配的情况
//            return isFirstMath && dfs(s.substring(1), p.substring(1));
//        }
//    }

}
