import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:5/16/21 1:18 PM
 */
public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> tmp = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) tmp.add(nums[j]);
            }
            res.add(tmp);
        }
        return res;
    }
}
