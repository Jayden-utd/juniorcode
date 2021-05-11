/**
 * @Description:
 * @author: Jayden
 * @date:5/10/21 2:15 PM
 */
public class Leetcode285 {
    class Solution {

        private TreeNode previous;
        private TreeNode inorderSuccessorNode;

        public TreeNode inorderSuccessorNormal(TreeNode root, TreeNode p) {

            // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
            if (p.right != null) {

                TreeNode leftmost = p.right;

                while (leftmost.left != null) {
                    leftmost = leftmost.left;
                }

                this.inorderSuccessorNode = leftmost;
            } else {

                // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
                this.inorderCase2(root, p);
            }

            return this.inorderSuccessorNode;
        }

        private void inorderCase2(TreeNode node, TreeNode p) {

            if (node == null) {
                return;
            }

            // Recurse on the left side
            this.inorderCase2(node.left, p);

            // Check if previous is the inorder predecessor of node
            if (this.previous == p && this.inorderSuccessorNode == null) {
                this.inorderSuccessorNode = node;
                return;
            }

            // Keeping previous up-to-date for further recursions
            this.previous = node;

            // Recurse on the right side
            this.inorderCase2(node.right, p);
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            //discard safely left subtree
            if (p.val >= root.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }

    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }







}
