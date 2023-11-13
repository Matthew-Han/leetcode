package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/21 15:16 21
 * @since 1.0
 **/
public class Ac796 {


    /**
     * 子矩阵的和
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        int k = arr[2];
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] sum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = (i - 1 >= 0 && j - 1 >= 0 ? sum[i - 1][j - 1] : 0);
                sum[i][j] = t
                        + (i - 1 >= 0 ? sum[i - 1][j] : 0) - t
                        + (j - 1 >= 0 ? sum[i][j - 1] : 0) - t
                        + matrix[i][j];
            }
        }
        for (int i = 0; i < k; i++) {
            int[] xy = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = xy[0] - 1;
            int x2 = xy[2] - 1;
            int y1 = xy[1] - 1;
            int y2 = xy[3] - 1;
            int s = sum[x2][y2]
                    - (y1 - 1 >= 0 ? sum[x2][y1 - 1] : 0)
                    - (x1 - 1 >= 0 ? sum[x1 - 1][y2] : 0)
                    + (x1 - 1 >= 0 && y1 - 1 >= 0 ? sum[x1 - 1][y1 - 1] : 0);
            System.out.println(s);
        }
    }

}
