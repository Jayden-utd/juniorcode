package calculator;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 3:46 PM
 */
public class Leetcode224 {
    public int calculate(String s) {
        int n = s.length(), res = 0, sign = 1, number = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '(') {
                int j = i, cnt = 0;
                for (; i < n; i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }
                number = calculate(s.substring(j + 1, i));
            }
            if (c == '+' || c == '-' || i == n - 1) {
                res += sign * number;
                number = 0;
                sign = (c == '+') ? 1 : -1;
            }
        }
        return res;
    }
}
