import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:4/3/21 12:00 PM
 */
public class Leetcode1814 {
    //2 sum hashmap 非常好的应用
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int tmp = rev(num);
            map.put(num - tmp, map.getOrDefault(num - tmp, 0) + 1);
            ans = (ans + map.get(num - tmp) - 1) % 1000000007;
        }
        return ans;
    }
    public  int rev(int num) {
        int res = 0;
        while(num != 0) {
            int tmp = num % 10;
            res = res * 10 + tmp;
            num /= 10;
        }
        return res;
    }
}
