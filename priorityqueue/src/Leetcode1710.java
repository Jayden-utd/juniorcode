import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:4/1/21 4:46 PM
 */
public class Leetcode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int[] a : boxTypes) pq.add(a);
        while (truckSize > 0 && !pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (tmp[0] <= truckSize) {
                res += tmp[0] * tmp[1];
                truckSize -= tmp[0];
            } else {
                res += truckSize * tmp[1];
                truckSize = 0;
            }
        }
        return res;
    }
}
