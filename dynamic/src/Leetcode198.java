/**
 * @Description:
 * @author: Jayden
 * @date:4/11/21 1:02 PM
 */
public class Leetcode198 {
    public int rob(int[] nums) {

        int prev = 0;

        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {

            int max = Math.max(cur, nums[i] + prev);
            prev = cur;
            cur = max;
        }
        return cur;


    }
}
