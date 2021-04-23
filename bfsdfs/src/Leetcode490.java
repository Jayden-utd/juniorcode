import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: Jayden
 * @date:4/21/21 7:21 PM
 */
public class Leetcode490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int row = maze.length, col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (tmp[0] == destination[0] && tmp[1] == destination[1]) return true;
            for (int[] direc : direction) {
                int x = tmp[0] + direc[0];
                int y = tmp[1] + direc[1];
                while (x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == 0) {
                    x += direc[0];
                    y += direc[1];
                }
                if (!visited[x - direc[0]][y - direc[1]]) {
                    queue.add(new int[]{x - direc[0], y - direc[1]});
                    visited[x - direc[0]][y - direc[1]] = true;
                }
            }
        }
        return false;
    }

//    public boolean hasPathDfs(int[][] maze, int[] start, int[] destination) {
//
//    }
}
