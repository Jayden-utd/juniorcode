import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:3/10/21 12:52 PM
 */
public class Leetcode253 {
    //和 my calendar732相似，很经典的一种思想 732是通过treemap
    //这个是 通过数组 记录 时间 +1  -1
    public int minMeetingRoomsOn(int[][] intervals) {
        if(intervals.length == 0) return 0;
        int maxtime = Integer.MIN_VALUE;
        //Find max meeting time
        for(int i = 0; i < intervals.length; i++){
            maxtime = Math.max(maxtime, intervals[i][1]);
        }
        int[] cont = new int[maxtime+1];
        for(int i = 0; i < intervals.length; i++){
            cont[intervals[i][0]]++;
            cont[intervals[i][1]]--;
        }
        int res = 0;
        for(int i = 1; i <= maxtime; i++){
            cont[i] += cont[i-1];
            res = Math.max(res, cont[i]);
        }
        return res;
    }


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
