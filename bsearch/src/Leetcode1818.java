import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:4/4/21 9:32 PM
 */
public class Leetcode1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] tmp = nums1.clone();
        Arrays.sort(tmp);
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res += Math.abs(nums1[i] - nums2[i]);
            res %= 1000000007;
        }
        int save = 0;
        for (int i = 0; i < nums1.length; i++) {
            // already equal, diff is already minimized
            if (nums1[i] == nums2[i]) continue;
            int index = Arrays.binarySearch(tmp, nums2[i]);
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (index >= 0) {
                save = Math.max(save, diff);
            } else {
                int actualIndex = -1 * (index  + 1);
                if (actualIndex > 0) save = Math.max(save, diff - Math.abs(nums2[i] - tmp[actualIndex-1]));
                if (actualIndex < nums1.length) save = Math.max(save, diff - Math.abs(nums2[i] - tmp[actualIndex]));
            }
        }
        return (res - save) % 1000000007;
    }
}
