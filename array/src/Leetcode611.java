import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:5/12/21 12:06 AM
 */
public class Leetcode611 {
    //O(n^2logn)
    public int triangleNumberBs(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int left = j + 1, right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < sum) {
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                res += right - 1 - j;
            }
        }
        return res;
    }

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int k = nums.length-1; k>1; k--) {
            int i = 0;
            int j = k-1;
            while (i<j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j-i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
