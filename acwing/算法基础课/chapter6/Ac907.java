package 算法基础课.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/28 17:16 28
 * @since 1.0
 **/
public class Ac907 {

    /**
     * 区间覆盖
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int s = Integer.parseInt(nk[0]);
        int t = Integer.parseInt(nk[1]);
        int m = Integer.parseInt(sc.readLine());
        int[][] matrix = new int[m][2];
        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(matrix, Comparator.comparingInt(o -> o[0]));
        if (matrix[0][0] > s) {
            System.out.println(-1);
            return;
        }
        int ans = 1;
        int p = s;
        int max = matrix[0][1];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > max) {
                System.out.println(-1);
                return;
            }
            if (matrix[i][0] > p) {
                p = max;
                ans++;
            }
            max = Math.max(matrix[i][1], max);
            if (max >= t) {
                System.out.println(ans);
                return;
            }
        }
        System.out.println(-1);
    }

}
