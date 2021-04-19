import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:3/31/21 11:21 PM
 */
public class Leetcode560 {
    public static void main(String[] args) {
        System.out.println(subarraySumSout(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23));
    }
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

    public static int subarraySumSout(int[] nums, int k) {
        int curSum = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum == k) {
                System.out.println(start + " " + i);
                break;
            } else if (curSum > k) {
                while (curSum > k && start < i) {
                    curSum = curSum - nums[start];
                    start++;
                }
                if (curSum == k) {
                    System.out.println(start + " " + i);
                    break;
                }
            }
        }
        System.out.println("No subarray found");
        return 0;

    }
}
