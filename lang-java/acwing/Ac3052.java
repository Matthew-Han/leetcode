import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/24 17:01
 * @since 1.0
 **/
public class Ac3052 {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();

    /**
     * 不同路径数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(mat, i, j, 0, k, new StringBuilder());
            }
        }
        System.out.println(set.size());
    }

    public static void dfs(int[][] mat, int x, int y, int size, int k, StringBuilder sb) {
        if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
            if (size == k + 1) {
                set.add(sb.toString());
                return;
            }
            for (int i = 0; i < dx.length; i++) {
                sb.append(mat[x][y]);
                dfs(mat, x + dx[i], y + dy[i], size + 1, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

}
