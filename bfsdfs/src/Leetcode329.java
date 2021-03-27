import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:3/23/21 11:11 AM
 */
//这个题费了很多时间，原因在于总喜欢 把 step 放进函数，会导致很多 多算入 问题
//并且本质上 参数里代入 step 也会有很多问题出现
public class Leetcode329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int length = dfs(matrix, m, n, i, j,  memo);
                max = Math.max(max, length);
            }
        }
        return max;
    }
    //Time complexity : O(mn)O(mn). Each vertex/cell will be calculated once and only once,
    // and each edge will be visited once and only once. The total time complexity is then O(V+E)O(V+E).
    // VV is the total number of vertices and EE is the total number of edges. In our problem,
    // O(V) = O(mn)O(V)=O(mn), O(E) = O(4V) = O(mn)O(E)=O(4V)=O(mn).
    public int dfs(int[][] matrix, int m, int n, int curX, int curY, int[][] memo) {
        if (memo[curX][curY] != 0) return memo[curX][curY];
        int curL = 1;
        if (curX + 1 < m && matrix[curX + 1][curY] > matrix[curX][curY]) {
            curL = Math.max(curL, 1 + dfs(matrix, m, n, curX + 1, curY,  memo));
        }
        if (curX - 1 >= 0 && matrix[curX - 1][curY] > matrix[curX][curY]) {
            curL = Math.max(curL, 1 + dfs(matrix, m, n, curX - 1, curY,  memo));
        }
        if (curY + 1 < n && matrix[curX][curY + 1] > matrix[curX][curY]) {
            curL = Math.max(curL, 1 + dfs(matrix, m, n, curX, curY + 1,  memo));
        }
        if (curY - 1>= 0 && matrix[curX][curY - 1] > matrix[curX][curY]) {
            curL = Math.max(curL, 1 + dfs(matrix, m, n, curX, curY - 1,  memo));
        }
        memo[curX][curY] = curL;
        return curL;
    }
}
