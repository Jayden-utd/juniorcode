import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:4/17/21 12:15 PM
 */
public class Leetcode1368 {
    public static void main(String[] args) {
        Leetcode1368 test = new Leetcode1368();
        System.out.println(test.minCost(new int[][]{{1,1,1,1}, {2,2,2,2}, {1,1,1,1}, {2,2,2,2}}));
    }
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        q.offer(new int[]{0, 0, 0});
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int cost = top[0], r = top[1], c = top[2];
            if (dist[r][c] != cost) continue;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0], nc = c + dir[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int ncost = cost;
                    if (i != grid[r][c] - 1) ncost += 1;
                    if (ncost < dist[nr][nc]) {
                        dist[nr][nc] = ncost;
                        q.offer(new int[]{ncost, nr, nc});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
