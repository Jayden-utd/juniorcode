import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:3/24/21 11:02 AM
 */
public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        ////剪枝 减少不必要的操作 n - i + 1 + list.size >= k
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
