package weektest;

/**
 * @Description:
 * @author: Jayden
 * @date:3/20/21 9:31 PM
 */
public class Leetcode1800 {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int n = nums.length, cur = 0;
        while(cur < n) {
            int sum = nums[cur];
            while(cur < n - 1 && nums[cur] < nums[cur + 1]) {
                sum += nums[cur + 1];
                cur++;
            }
            cur++;
            res = Math.max(res, sum);
        }
        return res;
    }

    //this way is a good way to show your code style
    public int maxAscendingSumClear(int[] nums) {
        int curSum = 0, max = 0, pre = Integer.MIN_VALUE;
        for (int num : nums) {
            curSum = pre < num ? curSum + num : num;
            max=  Math.max(max, curSum);
            pre = num;
        }
        return max;
    }
}
