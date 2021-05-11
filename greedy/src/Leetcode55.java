/**
 * @Description:
 * @author: Jayden
 * @date:5/4/21 5:51 PM
 */
public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int jumpMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (jumpMax >= nums.length - 1) return true;
            if (i <= jumpMax) {
                jumpMax = Math.max(jumpMax, nums[i] + i);
            }
        }
        return false;
    }
}
