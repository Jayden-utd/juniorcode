import java.util.TreeMap;

/**
 * @Description:
 * @author: Jayden
 * @date:5/9/21 10:47 AM
 */
public class Leetcode732 {
    public static void main(String[] args) {
        Leetcode732 test = new Leetcode732();
        test.book(10,20);
        test.book(50,60);
        test.book(10,40);
        test.book(5,15);
        test.book(5,10);
        test.book(25,55);
    }
    TreeMap<Integer, Integer> timeline;
    public Leetcode732() {
        timeline = new TreeMap<>();
    }

    public int book(int start, int end) {
        // 1 new event will be starting at [s]
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        // 1 new event will be ending at [e]
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int ongoing = 0, k = 0;
        for (int v : timeline.values())
            k = Math.max(k, ongoing += v);
        return k;
    }
}
