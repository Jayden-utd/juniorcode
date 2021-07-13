package weektest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:3/27/21 10:20 PM
 */
public class Leetcode5716 {
    public static void main(String[] args) {
        //System.out.println(numSplits("az"));
    }

    public static int[] minDifference(int[] nums, int[][] queries) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int[][] count = new int[nums.length + 1][max + 1];
        for (int i = 1; i < count.length; i++) {
            for (int j = 1; j < count[0].length; j++) {
                count[i][j] = count[i - 1][j];
            }
            count[i][nums[i - 1]]++;
        }

        int[] res = new int[queries.length];

        for(int i = 0; i < queries.length; ++i) {
            int low = queries[i][0];
            int high = queries[i][1] + 1;
            int min = 100;
            List<Integer> present = new ArrayList<>();
            for (int j = 1; j < max + 1; j++) {
                if(count[high][j] - count[low][j] != 0)
                    present.add(j);
            }
            for(int j = 1; j < present.size(); ++j) {
                min = Math.min(min, present.get(j) - present.get(j - 1));
            }

            if (present.size() == 1) {
                min = -1;
            }
            res[i] = min;

        }
        return res;
    }

}
