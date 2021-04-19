/**
 * @Description:
 * @author: Jayden
 * @date:4/13/21 4:24 PM
 */
public class Leetcode152 {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums) {
        for (int i = 1; i < nums.length; i++) {

        }

        return 0;
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 1], nums[i]);
            maxSum=Math.max(nums[i],maxSum);
        }
        return maxSum;
    }
}
