package google;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:8/5/21 6:24 PM
 */
public class Leetcode803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[hits.length];
        Set<Integer> noDrop = new HashSet<>();
        for (int i = 0; i < hits.length; i++) {
            grid[hits[i][0]][grid[i][1]] -= 1;
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                check(grid, 0, i, noDrop);
            }
        }
        for (int i = hits.length - 1; i >= 0; i--) {
            int oldSize = noDrop.size();
            int x = hits[i][0];
            int y = hits[i][1];
            if (++grid[x][y] != 1) continue;
            if ((x - 1 >= 0 && noDrop.contains((x - 1) * n + y))
                    || (x + 1 < m && noDrop.contains((x + 1) * n + y))
                    || (y - 1 >= 0 && noDrop.contains(x * n + y - 1))
                    || (y + 1 < n && noDrop.contains(x * n + y + 1))
                    || x == 0) {
                check(grid, x, y, noDrop);
                res[i] = noDrop.size() - oldSize - 1;
            }
        }
        return res;
    }

    private void check(int[][] grid, int i, int j, Set<Integer> noDrop) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1 || noDrop.contains(i * n + j)) return;
        noDrop.add(i * n + j);
        check(grid, i - 1, j, noDrop);
        check(grid, i + 1, j, noDrop);
        check(grid, i, j - 1, noDrop);
        check(grid, i, j + 1, noDrop);
    }
}
