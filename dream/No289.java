/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/20 16:33
 **/
public class No289 {
    /**
     * #289 生命游戏
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.8 MB , 在所有 Java 提交中击败了 78.89% 的用户
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = check(board, i, j);
                System.out.println(count);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = -1;
                    }
                }
                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = -2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int check(int[][] board, int i, int j) {
        int count = 0;
        if (i - 1 >= 0 && (board[i - 1][j] == -1 || board[i - 1][j] == 1)) {
            count++;
        }
        if (i + 1 < board.length && (board[i + 1][j] == -1 || board[i + 1][j] == 1)) {
            count++;
        }
        if (j - 1 >= 0 && (board[i][j - 1] == -1 || board[i][j - 1] == 1)) {
            count++;
        }
        if (j + 1 < board[0].length && (board[i][j + 1] == -1 || board[i][j + 1] == 1)) {
            count++;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == -1 || board[i - 1][j - 1] == 1)) {
            count++;
        }
        if (i + 1 < board.length && j + 1 < board[0].length && (board[i + 1][j + 1] == -1 || board[i + 1][j + 1] == 1)) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < board[0].length && (board[i - 1][j + 1] == -1 || board[i - 1][j + 1] == 1)) {
            count++;
        }
        if (i + 1 < board.length && j - 1 >= 0 && (board[i + 1][j - 1] == -1 || board[i + 1][j - 1] == 1)) {
            count++;
        }
        return count;

    }
}
