/**
 * @Description:
 * @author: Jayden
 * @date:6/30/21 10:39 AM
 */
public class Leetcode1254 {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    boolean isClosed = dfs(grid, i, j);
                    if (isClosed) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return false;
        }
        if (grid[i][j] != 0) return true;
        grid[i][j] = 1;
        return dfs(grid,i+1,j) & dfs(grid,i-1,j) & dfs(grid,i,j-1) & dfs(grid,i,j+1);
    }
}
/*
* [1,1,1,1,1,1,1,1,1,1],
* [1,1,0,1,1,0,1,1,1,1],
* [1,0,1,1,1,0,0,1,1,1],
* [0,1,1,0,0,0,0,1,0,1],
* [0,0,0,0,0,0,1,1,1,1],
* [0,1,0,1,0,1,0,1,1,1],
* [1,0,1,0,1,1,0,0,0,1],
* [1,1,1,1,1,1,0,0,0,1],
* [1,1,1,0,0,1,0,1,0,1],
* [1,1,1,0,1,1,0,1,1,0]
*
*
* */