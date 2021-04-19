import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:4/11/21 11:07 AM
 */
public class Leetcode740 {
    //打家劫舍 lc198 转换
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;


        int[] dp = new int[10001];
        dp[1] = values[1];
        for (int i = 2; i < values.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + values[i]);
        }
        return dp[10000];
    }




    public static List<Integer> meaderingArray(List<Integer> unsorted) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(unsorted);
        int length = unsorted.size();
        int j = length - 1;
        int i = 0;
        while (i <= j) {
            if (i == j) {
                result.add(unsorted.get(i));
                break;
            }
            result.add(unsorted.get(j));
            result.add(unsorted.get(i));
            i++;
            j--;
        }
        return result;
    }
}
