import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:3/22/21 9:20 PM
 */
public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }
    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        //time n! * n
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, list, res, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
