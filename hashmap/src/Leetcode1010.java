import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:3/31/21 8:24 PM
 */

//x % 60 = 60 - t % 60
//but one case cannot satisty
public class Leetcode1010 {
    //2 sum
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : time) {
            map.put(i % 60, map.getOrDefault(i % 60, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getKey())) continue;
            if (entry.getKey() % 60 == 0 || entry.getKey() == 30) {
                res += entry.getValue() * (entry.getValue() - 1) / 2;
            } else {
                int target = 60 - entry.getKey();
                if (!map.containsKey(target)) continue;
                res += entry.getValue() * map.get(target);
                set.add(target);
            }
            set.add(entry.getKey());
        }
        return res;
    }

    public int numPairsDivisibleBy60Clear(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60]++;
        }
        return res;
    }
}
