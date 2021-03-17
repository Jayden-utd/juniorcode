/**
 * @Description:
 * @author: Jayden
 * @date:2/22/21 10:39 PM
 */
public class Leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        return left == null ? right : right == null ? left : root;
    }
}
