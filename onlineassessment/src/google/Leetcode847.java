package google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:7/9/21 12:01 PM
 */
public class Leetcode847 {
    public static void main(String[] args) {
        Leetcode847 test = new Leetcode847();
        System.out.println(1 << 0);
        int[][] graph = new int[][]{{1,2,3},{0},{0},{0}};
        test.shortestPathLength(graph);
    }


    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int target = (1 << n) - 1;
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.offer(new int[]{mask, i});

            visited.add(mask + " " + i);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                if (tmp[0] == target) return level;
                for (int next : graph[tmp[1]]) {
                    int path = tmp[0] | (1 << next);
                    String nextPath = path + " " + next;
                    if (visited.contains(nextPath)) continue;
                    visited.add(nextPath);
                    queue.offer(new int[]{path, next});
                }
            }
            level++;
        }
        return level;
    }
    class Node {

    }
}
