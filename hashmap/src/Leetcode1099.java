import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 2:17 PM
 */
public class Leetcode1099 {
    //sum < k so use lower not floor
    public int twoSumLessThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = -1;
        for (int a : nums) {
            Integer pre = set.lower(k - a);
            if (pre != null) {
                res = Math.max(res, a + pre);
            }
            set.add(a);
        }
        return res;
    }

    //返回所有坐标 包含重复
    public static int[][] allPairSum (int[] arr, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> resList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int remain = target - arr[i];
            if (map.containsKey(remain)) {
                List<Integer> indexes = map.get(remain);
                for (int index : indexes) {
                    resList.add(new int[]{index,i});
                }
            }
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                map.put(arr[i], list);
                map.get(arr[i]).add(i);
            }
        }
        int[][] result = new int[resList.size()][2];
        int index = 0;
        while (index < resList.size()) {
            result[index] = resList.get(index);
            index++;
        }
        return result;
    }

    //返回 最靠近的
    public static int[][] cloest (int[] arr, int target) {
        int[][] result = new int[1][2];
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                if (arr[left] + arr[right] > sum) {
                    result[0][0] = arr[left];
                    result[0][1] = arr[right];
                    sum = arr[left] + arr[right];
                }
                left++;
            }else{
                right--;
            }
        }
        result[0][0] = map.get(result[0][0]);
        result[0][1] = map.get(result[0][1]);
        return result;
    }
}
