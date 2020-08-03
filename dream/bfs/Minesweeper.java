package bfs;

import java.util.Arrays;

/**
 * @ClassName Minesweeper
 * @Description #529 扫雷游戏
 * @Author MatthewHan
 * @Date 2020/8/3 15:23
 * @Version 1.0
 **/
public class Minesweeper {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 80.49% 的用户
     *
     * @param board
     * @param click
     * @return
     */
    public static char[][] updateBoard(char[][] board, int[] click) {

        // 第一步踩到炸弹的情况单独列出
        char resp = board[click[0]][click[1]];
        if (resp == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            bfs(board, click[0], click[1]);
        }
        return board;
    }

    public static void bfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        char resp = board[x][y];

        int mineCount = 0;
        // 这个当成标识，如果BFS到周边的格子不是E的话，说明走过了，就不走，类似visit[]
        if (resp == 'E') {

            if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 'M') {
                mineCount++;
            }
            if (x - 1 >= 0 && board[x - 1][y] == 'M') {
                mineCount++;
            }
            if (x - 1 >= 0 && y + 1 < board[0].length && board[x - 1][y + 1] == 'M') {
                mineCount++;
            }
            if (y - 1 >= 0 && board[x][y - 1] == 'M') {
                mineCount++;
            }
            if (y + 1 < board[0].length && board[x][y + 1] == 'M') {
                mineCount++;
            }
            if (x + 1 < board.length && y - 1 >= 0 && board[x + 1][y - 1] == 'M') {
                mineCount++;
            }
            if (x + 1 < board.length && board[x + 1][y] == 'M') {
                mineCount++;
            }
            if (x + 1 < board.length && y + 1 < board[0].length && board[x + 1][y + 1] == 'M') {
                mineCount++;
            }

            board[x][y] = mineCount == 0 ? 'B' : (char) (mineCount + 48);

            // 周围扫出雷了，就结束
            if (mineCount <= 0) {
                bfs(board, x - 1, y - 1);
                bfs(board, x - 1, y);
                bfs(board, x - 1, y + 1);
                bfs(board, x, y - 1);
                bfs(board, x, y + 1);
                bfs(board, x + 1, y - 1);
                bfs(board, x + 1, y);
                bfs(board, x + 1, y + 1);
            }


        }
        System.out.println(board[x][y]);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};

        System.out.println(Arrays.deepToString(updateBoard(board, new int[]{3, 0})));
    }
}
