import java.util.Stack;

/**
 * @Description:
 * @author: Jayden
 * @date:4/19/21 6:26 PM
 */
public class Leetcode1597 {
    public static void main(String[] args) {
        Leetcode1597 test = new Leetcode1597();

        System.out.println(test.infixToPostfix("3*4-2*5"));
        test.expTree("3*4-2*5");
    }
    public Node expTree(String s) {
        String postFix = infixToPostfix(s);
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < postFix.length(); i++) {

            Node tmp = new Node(postFix.charAt(i));
            if (tmp.val == '+' || tmp.val == '-' || tmp.val == '*' || tmp.val == '/') {
                tmp.right = stack.pop();
                tmp.left = stack.pop();
                stack.push(tmp);
            } else {
                stack.push(tmp);
            }
        }
        return stack.pop();
    }
    /**
     * 中缀表达式转换为后缀表达式 "3*4-2*5" -> "34*25-"
     * 后缀表达式也就是逆波兰表达式。
     */
    public String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '+' || tmp == '-') {
                while(!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.push(s.charAt(i));
            } else if (tmp == '*' || tmp == '/') {
                while(!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-')
                    sb.append(stack.pop());
                stack.push(s.charAt(i));
            } else if (tmp == '(') {
                stack.push(tmp);
            } else if (tmp == ')') {
                while (stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop();
            } else {
                stack.push(tmp);
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
