import java.util.Stack;

/**
 * @Description:
 * @author: Jayden
 * @date:4/19/21 3:44 PM
 */
public class Leetcode1628 {
    //很好的题目，非常适合面试考察基础知识
    Node buildTree(String[] postfix) {
        String operators = "+-*/";
        Stack<TNode> stack = new Stack<>();
        for (String fix : postfix) {
            if (operators.contains(fix)) {
                 TNode cur = new TNode(fix);
                 cur.right = stack.pop();
                 cur.left = stack.pop();
                 stack.push(cur);
            } else {
                stack.push(new TNode(fix));
            }
        }
        return stack.pop();
    }
}


abstract class Node {
    public abstract int evaluate();
    // define your fields here
}

class TNode extends Node {
    String val;
    TNode left;
    TNode right;
    TNode(String val) {
        this.val = val;
    }
    @Override
    public int evaluate() {
        return dfs(this);
    }
    private int dfs(TNode root) {
        if (root.left == null && root.right == null) {
            return Integer.valueOf(root.val);
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        String operator = root.val;
        int res = 0;
        if ("+".equals(operator)) {
            res = left + right;
        } else if ("-".equals(operator)) {
            res = left - right;
        } else if ("*".equals(operator)) {
            res = left * right;
        } else {
            res = left / right;
        }
        return res;
    }
}

