import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:3/8/21 10:54 PM
 */
public class Leetcode560 {
    //因为要求连续的数组  最开始想到的是 window，但是因为有负数可能
    //所以 window的 想法不可行，所以 要么presum
    //但其实presum 的本质还是 暴力解法，所以考虑map存储
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
