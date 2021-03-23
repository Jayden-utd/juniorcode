import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @author: Jayden
 * @date:3/19/21 9:16 PM
 */
public class Leetcode1730 {
    public int getFood(char[][] grid) {
        int[] start = new int[2];
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if('*' == grid[i][j]) {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        int step =0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] next = queue.poll();
                int tmpX = next[0], tmpY = next[1];
                if (grid[tmpX][tmpY] == 'X') continue;
                if (grid[tmpX][tmpY] == '#') {
                    return step;
                }
                //条件的判定 要注意 不能 == 'O' 因为 有可能下一个还是食物呢 所以我们只要不是 X 都可以接着走
                if (tmpX + 1 < m && grid[tmpX + 1][tmpY] != 'X' ) queue.add(new int[]{tmpX + 1, tmpY});
                if (tmpY + 1 < n && grid[tmpX][tmpY + 1] != 'X' ) queue.add(new int[]{tmpX, tmpY + 1});
                if (tmpX - 1 >= 0 && grid[tmpX - 1][tmpY] != 'X' ) queue.add(new int[]{tmpX - 1, tmpY});
                if (tmpY - 1 >= 0 && grid[tmpX][tmpY - 1] != 'X' ) queue.add(new int[]{tmpX, tmpY - 1});
                grid[tmpX][tmpY] = 'X';
            }
            step++;
        }
        return -1;
    }
}
