import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:42
 * @description
 * @since 1.0.0
 **/
public class Ac3663 {

    /**
     * 打印数字菱形
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = n * 2 + 1;
        int[][] matrix = new int[len][len];
        Queue<int[]> queue = new LinkedList<>();
        matrix[n][n] = n;
        queue.offer(new int[]{n, n, n + 1});
        boolean[][] vis = new boolean[len][len];
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            vis[curr[0]][curr[1]] = true;
            matrix[curr[0]][curr[1]] = curr[2];
            if (curr[0] - 1 >= 0 && !vis[curr[0] - 1][curr[1]]) {
                queue.offer(new int[]{curr[0] - 1, curr[1], curr[2] - 1});
            }
            if (curr[1] - 1 >= 0 && !vis[curr[0]][curr[1] - 1]) {
                queue.offer(new int[]{curr[0], curr[1] - 1, curr[2] - 1});
            }
            if (curr[0] + 1 < len && !vis[curr[0] + 1][curr[1]]) {
                queue.offer(new int[]{curr[0] + 1, curr[1], curr[2] - 1});
            }
            if (curr[1] + 1 < len && !vis[curr[0]][curr[1] + 1]) {
                queue.offer(new int[]{curr[0], curr[1] + 1, curr[2] - 1});
            }
        }
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (flag && matrix[i][j] <= 0) {
                    break;
                }
                if (matrix[i][j] <= 0) {
                    sb.append(" ");
                } else {
                    flag = true;
                    sb.append(matrix[i][j] - 1);
                }
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
