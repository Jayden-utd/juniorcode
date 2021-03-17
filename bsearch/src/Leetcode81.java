/**
 * @Description:
 * @author: Jayden
 * @date:2/26/21 10:08 AM
 */
public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            //寻找有序的一段 去 判断二分的方向
            if(nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                right--;
            }
        }
        return false;
    }
}
