import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:5/2/21 8:57 PM
 */
public class Leetcode630 {
    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][]{{1, 2}, {3, 4}, {7, 7}, {12, 12}}));
    }
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int cost = 0;
        for (int[] course : courses) {
            if (cost + course[0] <= course[1]) {
                cost += course[0];
                pq.offer(course[0]);
            } else if (!pq.isEmpty() && pq.peek() > course[0]) {
                cost += course[0] - pq.poll();
                pq.offer(course[0]);
            }
        }
        return pq.size();

    }
}
