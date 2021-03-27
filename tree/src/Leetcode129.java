/**
 * @Description:
 * @author: Jayden
 * @date:3/24/21 4:21 PM
 */
public class Leetcode129 {
    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int curNum) {
        if (root == null) return;
        curNum = curNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curNum;
            return;
        }
        dfs(root.left, curNum);
        dfs(root.right, curNum);
    }


    public int sumNumbersClear(TreeNode root) {
        return sum(root, 0);
    }
    //这种方式 可以再试着 脑补一下  1 2 3 4 5 根节点返回的其实 是 两个的和
    public int sum(TreeNode n, int s) {
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s * 10 + n.val;
        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
    }
}
