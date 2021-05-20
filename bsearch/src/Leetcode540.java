/**
 * @Description:
 * @author: Jayden
 * @date:5/19/21 9:30 PM
 */
public class Leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        int left=0, right=nums.length-1, n = nums.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid] == nums[mid + 1]) {
                if ((n - mid) % 2 == 0) right = mid - 1;
                else left = mid;
            } else {
                if (mid == 0 || nums[mid] != nums[mid - 1]) return nums[mid];
                if ((mid + 1) % 2 == 0) left = mid + 1;
                else right = mid;
            }
        }
        return nums[left];
    }
}
