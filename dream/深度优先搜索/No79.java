package 深度优先搜索;

/**
 * @ClassName WordSearch
 * @Description #79 单词搜索
 * @Author MatthewHan
 * @Date 2020/9/13 00:25
 * @Version 1.0
 **/
public class No79 {


    /**
     * 执行用时： 236 ms , 在所有 Java 提交中击败了 5.04% 的用户
     * 内存消耗： 43.7 MB , 在所有 Java 提交中击败了 5.10% 的用户
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == start) {
                    boolean[][] vis = new boolean[board.length][board[0].length];
                    if (dfs(board, word, i, j, 0, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean dfs(char[][] board, String word, int i, int j, int size, boolean[][] vis) {
        if (size == word.length()) {
            return true;
        }
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && !vis[i][j]) {
            vis[i][j] = true;
            if (word.charAt(size) != board[i][j]) {
                return false;
            }
            int m = board.length;
            int n = board[0].length;
            boolean[][] tmp1 = vis(vis, m, n);
            boolean[][] tmp2 = vis(vis, m, n);
            boolean[][] tmp3 = vis(vis, m, n);
            boolean[][] tmp4 = vis(vis, m, n);

            return dfs(board, word, i + 1, j, size + 1, tmp1) ||
                    dfs(board, word, i - 1, j, size + 1, tmp2) ||
                    dfs(board, word, i, j + 1, size + 1, tmp3) ||
                    dfs(board, word, i, j - 1, size + 1, tmp4);

        }
        return false;
    }

    /**
     * 经典浅拷贝!
     * 这里新的vis二维数组，一定要深度拷贝，不能在原基础上直接对二维数组直接System.arrayCopy
     * 这样的话，虽然是新的对象，但是里面的一维数组还是原对象。
     *
     * @param vis
     * @param m
     * @param n
     * @return
     */
    public static boolean[][] vis(boolean[][] vis, int m, int n) {
        boolean[][] res = new boolean[m][n];
        for (int i = 0; i < vis.length; i++) {
            System.arraycopy(vis[i], 0, res[i], 0, vis[i].length);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
        System.out.println(exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "cdba"));
    }


    public static boolean dfs(int s) {
        System.out.println("s = " + s);
        if (s >= 4) {
            return false;
        } else {
            return dfs(s + 3) || dfs(s + 1);
        }


    }


}
