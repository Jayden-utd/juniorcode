/**
 * @Description:
 * @author: Jayden
 * @date:2/26/21 9:52 AM
 */
public class Leetcode33 {
    public static void main(String[] args) {
        Leetcode33 test = new Leetcode33();
        System.out.println(test.search(new int[]{1,1,2,1,1}, 1));
    }
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
