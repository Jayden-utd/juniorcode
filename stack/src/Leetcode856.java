import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @author: Jayden
 * @date:3/8/21 2:29 PM
 */
public class Leetcode856 {
    public static void main(String[] args) {
        Leetcode856 test = new Leetcode856();
        test.scoreOfParentheses("()");
    }
    public int scoreOfParenthesesRecur(String S) {
        int res = 0, n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == ')') continue;
            int pos = i + 1, cnt = 1;
            while (cnt != 0) {
                if(S.charAt(pos++) == ')') {
                    cnt--;
                } else {
                    cnt++;
                }
            }
            int cur = scoreOfParenthesesRecur(S.substring(i + 1, pos - 1));
            //因为假如中间是空串，那么返回值是0，乘以2还是0，但是 "()" 的分值应该是1，所以累加的时候要跟1做比较
            res += Math.max(2 * cur, 1);
            i = pos - 1;
        }
        return res;
    }
    public int scoreOfParentheses(String S) {
        int res = 0, n = S.length();
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            //因为碰到了 (  所以 进栈当前的res  res是 ( 之前的和
            if (c == '(') {
                stack.push(res);
                res = 0;
            } else {
                res = stack.pop() + Math.max(2 * res, 1);
            }
        }
        return res;
    }
}
