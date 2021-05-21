package 二维数组;

/**
 * @ClassName 二维数组.AvailableCapturesForRook
 * @Description #999 可以被一步捕获的棋子数
 * @Author MatthewHan
 * @Date 2020/7/1 09:09
 * @Version 1.0
 **/
public class No999 {

    /**
     * 999 题啦~虽然不是一题一题刷上来的
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param board
     * @return
     */
    public static int numRookCaptures(char[][] board) {
        int sum = 0;
        int[] location = positioning(board);
        int x = location[0];
        int y = location[1];

        int x1 = x;
        while (x1 >= 0) {
            if (board[x1][y] == 'B') {
                break;
            }
            if (board[x1][y] == 'p') {

                sum++;
                break;
            }
            x1--;
        }


        int x2 = x;
        while (x2 < 8) {
            if (board[x2][y] == 'B') {
                break;
            }
            if (board[x2][y] == 'p') {
                sum++;
                break;
            }
            x2++;
        }

        int y1 = y;
        while (y1 >= 0) {
            if (board[x][y1] == 'B') {
                break;
            }
            if (board[x][y1] == 'p') {
                sum++;
                break;
            }
            y1--;
        }

        while (y < 8) {
            if (board[x][y] == 'B') {
                break;
            }
            if (board[x][y] == 'p') {
                sum++;
                break;
            }
            y++;
        }
        return sum;
    }

    public static int[] positioning(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
