import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:5/13/21 4:10 PM
 */
public class Leetcode694 {
    public static void main(String[] args) {
        Leetcode694 test = new Leetcode694();
        test.numDistinctIslands(new int[][]{{1,1,0,0}, {1,1,0,0},{0,0,0,0},{0,0,0,0}});
    }
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    System.out.println(sb.toString());
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length
                || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i, j+1, sb, "r");
        dfs(grid, i+1, j, sb, "d");
        dfs(grid, i, j-1, sb, "l");
        dfs(grid, i-1, j, sb, "u");
        sb.append("b"); // back
    }
}
