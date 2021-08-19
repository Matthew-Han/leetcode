import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/19 09:38
 * @since 1.0
 **/
public class Lcp22 {

    int ans;
    Set<String> set;

    /**
     * 黑白方格画
     *
     * @param n
     * @param k
     * @return
     */
    public int paintingPlan(int n, int k) {
        ans = 0;
        set = new HashSet<>();
        dfs(new boolean[n][n], k, 0);
        return ans;
    }

    public void dfs(boolean[][] board, int k, int cnt) {
        if (cnt == k) {
            ans++;
            return;
        } else if (cnt > k) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            boolean[][] next1 = clone(board);
            int flag = paint(next1, true, i, cnt);
            String v = convert(next1);
            if (flag > cnt && !set.contains(v)) {
                set.add(v);
                dfs(next1, k, flag);
            }

            boolean[][] next2 = clone(board);
            flag = paint(next2, false, i, cnt);
            v = convert(next2);
            if (flag > cnt && !set.contains(v)) {
                set.add(v);
                dfs(next2, k, flag);
            }
        }

    }

    public boolean[][] clone(boolean[][] board) {
        boolean[][] ans = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, ans[i], 0, board.length);
        }
        return ans;
    }

    public int paint(boolean[][] board, boolean rc, int index, int cnt) {
        int tmp = 0;
        if (rc) {
            boolean[] r = board[index];
            for (int i = 0; i < board.length; i++) {
                if (!r[i]) {
                    tmp++;
                }
                r[i] = true;
            }

        } else {
            for (int j = 0; j < board.length; j++) {
                if (!board[j][index]) {
                    tmp++;
                }
                board[j][index] = true;
            }
        }
        return cnt + tmp;
    }

    public String convert(boolean[][] board) {
        StringBuilder sb = new StringBuilder();
        for (boolean[] a : board) {
            for (boolean b : a) {
                sb.append(b ? 1 : 0);
            }
        }
        return sb.toString();
    }

}
