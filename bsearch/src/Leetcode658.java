import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:7/21/21 10:04 PM
 */
public class Leetcode658 {
    //O(n)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sub = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = left; i <= right; i++) {
            sub.add(arr[i]);
        }
        return sub;
    }
}
