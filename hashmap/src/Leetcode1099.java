
import java.util.TreeSet;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 2:17 PM
 */
public class Leetcode1099 {
    //sum < k so use lower not floor
    public int twoSumLessThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = -1;
        for (int a : nums) {
            Integer pre = set.lower(k - a);
            if (pre != null) {
                res = Math.max(res, a + pre);
            }
            set.add(a);
        }
        return res;
    }
}
