import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * @Description:
 * @author: Jayden
 * @date:3/8/21 11:27 PM
 */
public class Leetcode394 {
    public static void main(String[] args) {
        Leetcode394 test = new Leetcode394();
        System.out.println(test.decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        String cur = "";
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char tmp = s.charAt(i);
            if (Character.isDigit(tmp)) {
                num = num * 10 + tmp - '0';
            } else if('[' == tmp) {
                stack.push(num);
                num = 0;
                int j = i, cnt = 0;
                for (; i < n; i++) {
                    if ('[' == s.charAt(i)) cnt++;
                    if (']' == s.charAt(i)) cnt--;
                    if (cnt == 0) break;
                }
                cur = decodeString(s.substring(j + 1, i));
                int repeat = stack.pop();
                for (int k = 0; k < repeat; k++) {
                    res.append(cur);
                }
            } else {
                res.append(tmp);
            }
        }
        return res.toString();
    }
}
