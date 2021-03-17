/**
 * @Description:
 * @author: Jayden
 * @date:2/26/21 11:01 AM
 */
public class Leetcode34 {
    //找一个target的 左右边界
    public int[] searchRange(int[] nums, int target){
        int[] res = new int[]{-1, -1};
        int left = 0, right = nums.length;
        //find left
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (right == nums.length || nums[right] != target) return res;
        res[0] = right;
        right = nums.length;
        //find right
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        res[1] = right - 1;
        return res;
    }
}
