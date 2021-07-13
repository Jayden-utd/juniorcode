package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:7/8/21 10:05 AM
 */
public class Leetcode428 {
    public static void main(String[] args) {
        Leetcode428 test = new Leetcode428();
        String res = "1";
        test.helper(res);
        System.out.println(res);

    }

    public void helper(String res) {
        res = "9292";
    }


    public String serialize(Node root) {
        String res = "";
        return helper(root, res);
    }

    public String helper(Node root, String res) {
        if (root == null) {
            return "";
        } else {
            res += root.val + " " + root.children.size() + " ";
            //res.append(root.val).append(" ").append(root.children.size()).append(" ");
            for (Node child : root.children) {
                res = helper(child, res);
            }
            return res;
        }
    }
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        return deserialize(new ArrayList<>(Arrays.asList(data.split(" "))));
    }

    public Node deserialize(List<String> q) {
        int r = Integer.parseInt(q.remove(0));
        int size = Integer.parseInt(q.remove(0));
        Node root = new Node(r, new ArrayList<Node>());
        for(int i =0;i<size;i++)
            root.children.add(deserialize(q));
        return root;
    }

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


}
