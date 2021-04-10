/**
 * @Description:
 * @author: Jayden
 * @date:4/8/21 10:56 AM
 */
public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] costs = new int[s.length()];
        int res = 0;
        int cost = 0;
        int left = 0;
        for (int i = 0; i < costs.length; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
            cost += costs[i];
            while (cost > maxCost) {
                cost -= costs[left++];
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
