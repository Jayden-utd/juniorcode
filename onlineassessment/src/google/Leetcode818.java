package google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:7/9/21 10:40 AM
 */
public class Leetcode818 {
    public static void main(String[] args) {
        Leetcode818 test = new Leetcode818();
        System.out.println(test.racecar(6));
    }
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1});
        Set<String> visited = new HashSet<>();
        visited.add("0,1");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == target) {
                    return step;
                }
                int newPos = cur[0] + cur[1];
                int newSpeed = cur[1] * 2;

                String key = newPos + "," + newSpeed;
                if (!visited.contains(key) && newPos < target * 2 && newPos > 0) {
                    queue.offer(new int[]{cur[0] + cur[1], cur[1] * 2});
                    visited.add(key);
                }
                newPos = cur[0];
                newSpeed = cur[1] > 0 ? -1 : 1;
                key = cur[0] + "," + newSpeed;
                if (!visited.contains(key) && newPos < target * 2 && newPos > 0) {
                    queue.offer(new int[]{cur[0], newSpeed});
                    visited.add(key);
                }
            }
            step++;
        }
        return -1;
    }
}
