package 二维数组;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/18 14:20
 **/
public class No36 {

    /**
     * #36 有效的数独
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 95.48% 的用户
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 60.53% 的用户
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkColumn(board) && check3x3(board);
    }

    /**
     * 检查行
     *
     * @param board
     * @return
     */
    public boolean checkRow(char[][] board) {
        for (char[] chars : board) {
            boolean flag = checkRepeat(chars);
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查列
     *
     * @param board
     * @return
     */
    public boolean checkColumn(char[][] board) {
        int len = board[0].length;
        for (int i = 0; i < len; i++) {
            char[] newChar = new char[len];
            int index = 0;
            for (int j = 0; j < len; j++) {
                newChar[index++] = board[j][i];
            }
            boolean flag = checkRepeat(newChar);
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public boolean check3x3(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        return dfs(board, 0, 0, vis);
    }

    /**
     * 检查数独数组中的小 3 x 3 格子
     *
     * @param board
     * @param i
     * @param j
     * @param vis
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, boolean[][] vis) {
        if (i > 8 || j > 8 || vis[i][j]) {
            return true;
        }
        char[] tmp = new char[9];
        int index = 0;
        for (int ii = i; ii < i + 3; ii++) {
            for (int jj = j; jj < j + 3; jj++) {
                vis[ii][jj] = true;
                tmp[index++] = board[ii][jj];
            }
        }
        boolean flag = checkRepeat(tmp);
        return flag &&
                dfs(board, i + 3, j, vis) &&
                dfs(board, i, j + 3, vis) &&
                dfs(board, i + 3, j + 3, vis);
    }

    /**
     * 检查数组重油污重复的数字,剔除.
     *
     * @param arr
     * @return
     */
    public boolean checkRepeat(char[] arr) {
        int[] bucket = new int[9];
        for (char n : arr) {
            if (n != '.') {
                bucket[n - '1']++;
                if (bucket[n - '1'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
