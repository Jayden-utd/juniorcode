/**
 * @Description:
 * @author: Jayden
 * @date:4/19/21 6:31 PM
 */
public class Node {
    char val;
    Node left;
    Node right;

    Node() {
        this.val = ' ';
    }

    Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
