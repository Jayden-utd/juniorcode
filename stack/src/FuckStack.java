import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @author: Jayden
 * @date:3/8/21 4:10 PM
 */
public class FuckStack {
    public static void main(String[] args) {
        String res = "";
        System.out.println(res.isEmpty());
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            } else {
                //if else 的合理应用 注意逻辑
                if (!stack.isEmpty() && leftof(tmp)==stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public char leftof(char c){
        if (c == ')') return '(';
        if (c == '}') return '{';
        return '[';
    }
}
