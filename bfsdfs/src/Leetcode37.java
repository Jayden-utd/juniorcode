/**
 * @Description:
 * @author: Jayden
 * @date:7/25/21 2:49 PM
 */
public class Leetcode37 {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        if (j == 9) {
            return dfs(board, i + 1, 0);
        }
        if (i == 9) return true;

        if (board[i][j] != '.') {
            return dfs(board, i, j + 1);
        }

        for (char k = '1'; k <= '9'; k++) {
            if (!valid(board, i, j, k)) continue;
            board[i][j] = k;
            if (dfs(board, i, j + 1)) return true;
            board[i][j] = '.';
        }
        return false;
    }

    private boolean valid(char[][] board, int i, int j, char k) {
        for (int l = 0; l < 9; l++) {
            if (board[i][l] == k) return false;
            if (board[l][j] == k) return false;
            if (board[(i / 3) * 3 + l / 3][(j / 3) * 3 + l % 3] == k) return false;
        }
        return true;
    }


}
