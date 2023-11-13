package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SurroundedRegions
 * @Description #130 被围绕的区域
 * @Author MatthewHan
 * @Date 2020/8/11 09:04
 * @Version 1.0
 **/
public class No130 {

    boolean flag = true;

    /**
     * 拉胯，这方法
     * 执行用时： 18 ms , 在所有 Java 提交中击败了 5.40% 的用户
     * 内存消耗： 46.8 MB , 在所有 Java 提交中击败了 5.03% 的用户
     *
     * @param board
     */
    public void solve2(char[][] board) {
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == 'O') {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    List<int[]> tmp = new ArrayList<>();
                    dfs2(board, i, j, visited, tmp);
                    if (flag) {
                        for (int[] ints : tmp) {
                            board[ints[0]][ints[1]] = 'X';
                        }
                    } else {
                        // 重置
                        flag = true;
                    }
                }
            }
        }
    }


    public void dfs2(char[][] board, int x, int y, boolean[][] visited, List<int[]> set) {
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y] && board[x][y] == 'O') {
            visited[x][y] = true;
            // 说明「O」在边界
            if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                flag = false;
                return;
            }
            set.add(new int[]{x, y});
            dfs2(board, x - 1, y, visited, set);
            dfs2(board, x + 1, y, visited, set);
            dfs2(board, x, y - 1, visited, set);
            dfs2(board, x, y + 1, visited, set);
        }
    }


    /**
     * 示例:
     * <p>
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * <p>
     * 先将周围一圈做 dfs，都替换成符号 =，然后两次循环遍历，将剩下的「O」符合要求的变成「X」，最后将 = 复原
     * <p>
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 42.36% 的用户
     * 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 54.67% 的用户
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, visited);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '=') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    public static void dfs(char[][] board, int x, int y, boolean[][] visited) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y] && board[x][y] == 'O') {
            board[x][y] = '=';
            visited[x][y] = true;
            dfs(board, x - 1, y, visited);
            dfs(board, x + 1, y, visited);
            dfs(board, x, y - 1, visited);
            dfs(board, x, y + 1, visited);
        }
    }

    public static void main(String[] args) {
        int[][] tmp = new int[4][4];

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                if (i == 0 || i == tmp.length - 1 || j == 0 || j == tmp[i].length - 1) {
                    System.out.println(tmp[i][j]);
                }
            }
        }
    }
}
