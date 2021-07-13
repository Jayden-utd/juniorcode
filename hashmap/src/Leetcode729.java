import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Description:
 * @author: Jayden
 * @date:5/9/21 11:27 AM
 */
public class Leetcode729 {
    List<int[]> calendar;
    public Leetcode729() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] tmp : calendar) {
            if (tmp[0] < end && tmp[1] > start) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}
