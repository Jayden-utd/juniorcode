import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Description:
 * @author: Jayden
 * @date:5/9/21 9:45 PM
 */
public class Leetcode731 {
    //Evidently, two events [s1, e1) and [s2, e2) do not conflict if and only if one of them starts
    // after the other one ends: either e1 <= s2 OR e2 <= s1.
    // By De Morgan's laws, this means the events conflict when s1 < e2 AND s2 < e1.


    //we can also Math.max(iv[0], start) < Math.min(iv[1], end) to determine whether has conflict
    List<int[]> calendar;
    List<int[]> overlap;
    public Leetcode731() {
        calendar = new LinkedList<>();
        overlap = new LinkedList<>();
    }

    public boolean book(int start, int end) {
        for (int[] iv : overlap) {
            if (iv[0] < end && iv[1] > start) return false;
        }

        for (int[] iv : calendar) {
            if (Math.max(iv[0], start) < Math.min(iv[1], end)) {
                overlap.add(new int[]{Math.max(iv[0], start), Math.min(iv[1], end)});
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }





//    TreeMap<Integer, Integer> map;
//    public Leetcode731() {
//        map = new TreeMap<>();
//    }
//
//    public boolean book(int start, int end) {
//        map.put(start, map.getOrDefault(start, 0) + 1);
//        map.put(end, map.getOrDefault(end, 0) - 1);
//        int ongoing = 0;
//        for(int d : map.values()) {
//            ongoing += d;
//            if (ongoing >= 3) {
//                map.put(start, map.get(start) - 1);
//                map.put(end, map.get(end) + 1);
//                //if (map.get(start) == 0) map.remove(start);
//                return false;
//            }
//        }
//        return true;
//    }
}
