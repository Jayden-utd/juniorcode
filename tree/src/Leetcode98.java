/**
 * @Description:
 * @author: Jayden
 * @date:3/17/21 7:15 PM
 */
public class Leetcode98 {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null ) return true;
        boolean left = isValidBST(root.left);
        if (root.val <= prev) {
            return false;
        } else {
            prev = root.val;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
