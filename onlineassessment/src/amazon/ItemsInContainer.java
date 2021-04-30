package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 10:51 AM
 */
public class ItemsInContainer {
    //https://leetcode.com/discuss/interview-question/1148760/items-in-containers-amazon-oa

    public static List<Integer> numberOfItemsPre(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int n = s.length();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) == '|' ? 0 : 1;
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        TreeSet<Integer> pipes = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pipes.add(i+1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            Integer lower = pipes.ceiling(startIndices.get(i));
            Integer higher = pipes.floor(endIndices.get(i));

            if (lower != null && higher != null && lower <= higher) {
                result.add(prefixSum[higher] - prefixSum[lower-1]);
            }
        }

        return result;
    }



    public static List<Integer> numberOfItems(String s, List<List<Integer>> ranges) {

        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || ranges.size() == 0) return list;

        for (List<Integer> item : ranges) {

            int curr = getEnclosedItems(s, item.get(0), item.get(1));
            list.add(curr);
        }

        return list;
    }

    private static int getEnclosedItems(String str, int s, int e) {
        if (str.length() == 0) return 0;
        int ans = 0;
        int val = 0;
        boolean f1 = false;
        for (int j = s; j <= e; j++) {
            if (!f1 && str.charAt(j) == '|') {
                f1 = true;
            } else if (f1 == true && str.charAt(j) == '*') {
                val++;
            } else if (f1 == true && str.charAt(j) == '|') {
                ans += val;
                val = 0;
            }
        }
        return ans;
    }
}
