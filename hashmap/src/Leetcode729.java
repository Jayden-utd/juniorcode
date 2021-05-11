import java.util.TreeMap;

/**
 * @Description:
 * @author: Jayden
 * @date:5/9/21 11:27 AM
 */
public class Leetcode729 {
    TreeMap<Integer, Integer> map;
    public Leetcode729() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer pre = map.floorKey(start),
                next = map.ceilingKey(start);

        if ((pre == null || map.get(pre) <= start) && (next == null || end <= next)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}
