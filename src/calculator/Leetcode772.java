package calculator;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 3:34 PM
 */
public class Leetcode772 {
    public int calculate(String s) {
        int n = s.length(), num = 0, curRes = 0, res = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if ('(' == c) {
                int j = i, cnt = 0;
                for(; i < n; i++) {
                    if (s.charAt(i) == '(') ++cnt;
                    if (s.charAt(i)  == ')') --cnt;
                    if (cnt == 0) break;
                }
                num = calculate(s.substring(j+ 1, i));
            }
            //这个位置 因为 i == n - 1 的时候 也要进入
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
                switch (op) {
                    case '+': curRes += num; break;
                    case '-': curRes -= num; break;
                    case '*': curRes *= num; break;
                    case '/': curRes /= num; break;
                    default: break;
                }
                if (c == '+' || c == '-' || i == n - 1) {
                    res += curRes;
                    curRes = 0;
                }
                op = c;
                num = 0;
            }
        }
        return res;
    }
}
