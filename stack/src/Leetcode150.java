import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @author: Jayden
 * @date:3/8/21 11:17 PM
 */
public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (String token : tokens) {
            if (token.equals("+")) {
                int first = stack.poll();
                int second = stack.poll();
                stack.push(first + second);
            } else if (token.equals("-")) {
                int first = stack.poll();
                int second = stack.poll();
                stack.push(second - first);
            } else if (token.equals("*")) {
                int first = stack.poll();
                int second = stack.poll();
                stack.push(second * first);
            } else if (token.equals("/")) {
                int first = stack.poll();
                int second = stack.poll();
                stack.push(second / first);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        while (!stack.isEmpty()) {
            res += stack.poll();
        }
        return res;

    }
}
