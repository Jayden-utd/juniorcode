package google;

import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:7/27/21 9:28 AM
 */
public class Leetcode1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.diff == b.diff ? b.xPoint - a.xPoint : b.diff - a.diff));
        int res = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek().xPoint > k) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                res = Math.max(res, point[0] + point[1] + pq.peek().diff);
            }

            pq.add(new Node(point[1] - point[0], point[0]));

        }
        return res;
    }
    class Node {
        int diff;
        int xPoint;
        Node(int diff, int xPoint){
            this.diff = diff;
            this.xPoint = xPoint;
        }
    }
}
