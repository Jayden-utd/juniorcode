/**
 * @Description:
 * @author: Jayden
 * @date:5/10/21 3:07 PM
 */
public class Leetcode510 {
    //注意bst的性质
    //通过 node 相对于其 parent 的位置来判断，当 node 是其 parent 的左子结点时，
    // 我们知道此时 parent 的结点值一定大于 node，因为这是二叉搜索树的性质。若 node 是其 parent 的右子结点时，
    // 则将 node 赋值为其 parent，
    // 继续向上找，直到其 parent 结点不存在了，此时说明不存在大于 node 值的祖先结点，
    // 这说明 node 是 BST 的最后一个结点了，没有后继结点，直接返回 null 即可
    public Node inorderSuccessor(Node node) {
        Node succ = null;
        if (node.right != null) {
            succ = node.right;
            while (succ.left != null) {
                succ = succ.left;
            }
        } else {
            while (node.parent != null && node.parent.left != node) {
                node = node.parent;
            }
            succ = node.parent;
        }
        return succ;
    }



    //look up the value
    public Node inorderSuccessorNormal(Node node) {
        Node succ = null;
        if (node.right != null) {
            succ = node.right;
            while (succ.left != null) {
                succ = succ.left;
            }
        } else {
            succ = node.parent;
            while (succ != null && succ.val < node.val) {
                succ = succ.parent;
            }
        }
        return succ;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
