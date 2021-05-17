/**
 * @Description:
 * @author: Jayden
 * @date:5/12/21 6:07 PM
 */

public class Leetcode53 {
    public static void main(String[] args) {
        Leetcode53 test = new Leetcode53();
        int[] res = test.maxSubArrayWithIndex(new int[]{4, 6, -11, 3, 4, 5});
        System.out.println(res);
    }

//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int[] result = helper(nums, 0, nums.length - 1);
//        System.out.println("Sum " + result[0] + " start at " + result[1] + " end at " + result[2]);
//        return result[0];
//    }
//
//    private int[] helper(int[] nums, int start, int end) {
//        if (start == end) return new int[]{nums[start], start, start};
//        int mid = start + (end - start) / 2;
//        int[] leftMax = helper(nums, start, mid);
//        int[] rightMax = helper(nums, mid + 1, end);
//        int[] crossingMax = crossingSum(nums, start, end);
//        if (leftMax[0] > rightMax[0]) {
//            if (crossingMax[0] < leftMax[0]) return leftMax;
//            else
//                return crossingMax;
//        } else {
//            if (crossingMax[0] < rightMax[0]) return rightMax;
//            else
//                return crossingMax;
//        }
//    }
//
//    private int[] crossingSum(int[] nums, int start, int end) {
//        int mid = start + (end - start) / 2;
//        int leftMax = nums[mid];
//        int rightMax = nums[mid + 1];
//        int leftMaxIndex = mid;
//        int rightMaxIndex = mid + 1;
//        int[] result = new int[3];
//        int sum = 0;
//        for (int i = mid; i >= start; i--) {
//            sum += nums[i];
//            if (leftMax < sum) {
//                leftMax = sum;
//                leftMaxIndex = i;
//            }
//        }
//        sum = 0;
//        for (int i = mid + 1; i <= end; i++) {
//            sum += nums[i];
//
//            if (rightMax < sum) {
//                rightMax = sum;
//                rightMaxIndex = i;
//            }
//        }
//        result[0] = leftMax + rightMax;
//        result[1] = leftMaxIndex;
//        result[2] = rightMaxIndex;
//        return result;
//    }

    public int[] maxSubArrayWithIndex(int[] nums) {
        int n = nums.length;
        //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        int i = 0, j = 0;
        for (int k = 1; k < n; k++) {
            if (dp[k - 1] > 0) {
                dp[k] = dp[k - 1] + nums[k];
                if (dp[k] > max) {
                    j = k;
                    max = dp[k];
                }
            } else { // dp[k - 1] <= 0
                //这个地方不确定该如何写，因为不确定后半段是否是最大的，所以导致 i 也有问题。
                dp[k] = nums[k];
                if (dp[k] > max) {
                    //reset both start pointer i and end pointer j to new start position
                    i = k;
                    j = k;
                    max = dp[k];
                }
            }
        }

        return new int[] {i, j, max};
    }
}
