import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:2/22/21 10:39 PM
 */
public class Leetcode236 {

    private boolean pisEnd = false;
    private boolean qisEnd = false;
    private List<TreeNode> res1;
    private List<TreeNode> res2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(new ArrayList<TreeNode>(), root, p.val, q.val);
        for (int i = 0; i < Math.max(res1.size(), res2.size()); i++) {
            if (i >= Math.min(res1.size(), res2.size()) || res1.get(i).val != res2.get(i).val) return res1.get(i - 1);
        }
        return null;
    }
    public void backtrack(List<TreeNode> res, TreeNode node, int target1, int target2) {
        if ((pisEnd && qisEnd) || node == null) return;
        res.add(node);
        if (node.val == target1 && !pisEnd) {
            res1 = new ArrayList(res);
            pisEnd = true;
        } else if (node.val == target2 && !qisEnd) {
            res2 = new ArrayList(res);
            qisEnd = true;
        }
        backtrack(res, node.left, target1, target2);
        backtrack(res, node.right, target1, target2);
        res.remove(res.size() - 1);
        return;
    }


//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) return root;
//        TreeNode left = lowestCommonAncestor(root.left, p , q);
//        TreeNode right = lowestCommonAncestor(root.right, p , q);
//        return left == null ? right : right == null ? left : root;
//    }
//
//
//
//    public TreeNode lowestCommonAncestorMap(TreeNode root, TreeNode p, TreeNode q) {
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        parent.put(root, null);
//        stack.push(root);
//
//        while (!parent.containsKey(p) || !parent.containsKey(q)) {
//            TreeNode node = stack.pop();
//            if (node.left != null) {
//                parent.put(node.left, node);
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                parent.put(node.right, node);
//                stack.push(node.right);
//            }
//        }
//        Set<TreeNode> ancestors = new HashSet<>();
//        while (p != null) {
//            ancestors.add(p);
//            p = parent.get(p);
//        }
//        while (!ancestors.contains(q))
//            q = parent.get(q);
//        return q;
//    }
}
