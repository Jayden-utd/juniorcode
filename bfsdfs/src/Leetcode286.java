import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: Jayden
 * @date:5/4/21 5:22 PM
 */
public class Leetcode286 {
    public void wallsAndGates(int[][] rooms) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = rooms.length, cols = rooms[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int tmpX = tmp[0], tmpY = tmp[1];
                rooms[tmpX][tmpY] = step;
                for (int[] dir : directions) {
                    int newX = tmpX + dir[0], newY = tmpY + dir[1];
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                            && rooms[newX][newY] == Integer.MAX_VALUE && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
    }
}
