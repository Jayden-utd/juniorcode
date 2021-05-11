import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:5/9/21 10:25 PM
 */
public class Leetcode56 {
    //merge interval
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int index = -1;
        for (int[] interval : intervals) {
            if(index == -1 || intervals[index][1] < interval[0]) {
                intervals[++index] = interval;
            } else {
                intervals[index][1] = Math.max(intervals[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(intervals, index + 1);


    }
}
