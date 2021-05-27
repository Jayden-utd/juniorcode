package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:5/25/21 9:52 AM
 */
public class Easy_TwoSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Set<Integer> value = new HashSet<>();
        int[] res = new int[2];
        for(int i = 0; i < array.length; i++) {
            if(value.contains(targetSum - array[i])) {
                res[0] = array[i];
                res[1] = targetSum - array[i];
                return res;
            } else {
                value.add(array[i]);
            }
        }
        return new int[0];
    }
}
