import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:8/5/21 4:41 PM
 */
public class Leetcode919 {
    List<TreeNode> list;
    TreeNode root;

    public Leetcode919(TreeNode root) {
        this.root = root;
        list = new ArrayList<>();
        list.add(root);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).left != null) list.add(list.get(i).left);
            if (list.get(i).right != null) list.add(list.get(i).right);
        }
    }

    public int insert(int val) {
        int N = list.size();
        TreeNode next = new TreeNode(val);

        list.add(next);
        if (N % 2 == 1) {
            list.get((N - 1) / 2).left = next;
        } else {
            list.get((N - 1) / 2).right = next;
        }
        return list.get((N - 1) / 2).val;
    }

    public TreeNode get_root() {
        return root;
    }
}
