import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:3/10/21 12:52 PM
 */
public class Leetcode253 {
    public int minMeetingRooms(int[][] intervals) {
        int rooms = 1;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (queue.peek() > intervals[i][0]) {
                rooms++;
            } else {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return rooms;

    }
}
