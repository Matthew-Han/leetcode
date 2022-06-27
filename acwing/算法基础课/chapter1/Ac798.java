package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/22 15:00 22
 * @since 1.0
 **/
public class Ac798 {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        int q = nm[2];
        long[][] matrix = new long[n][m];
        long[][] t = new long[n + 10][m + 10];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(sc.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        for (int i = 0; i < q; i++) {
            int[] xyc = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = xyc[0] - 1;
            int y1 = xyc[1] - 1;
            int x2 = xyc[2] - 1;
            int y2 = xyc[3] - 1;
            int c = xyc[4];
            t[x1][y1] += c;
            t[x2 + 1][y1] -= c;
            t[x1][y2 + 1] -= c;
            t[x2 + 1][y2 + 1] += c;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t[i][j] += (i - 1 >= 0 ? t[i - 1][j] : 0)
                        + (j - 1 >= 0 ? t[i][j - 1] : 0)
                        - (i - 1 >= 0 && j - 1 >= 0 ? t[i - 1][j - 1] : 0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] += t[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 一维数组的方式去差分
     * 很一般
     *
     * @throws IOException
     */
    public static void singleDimensional() throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        int q = nm[2];
        long[][] matrix = new long[n][m];
        long[][] t = new long[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(sc.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        for (int i = 0; i < q; i++) {
            int[] xyc = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = xyc[0] - 1;
            int y1 = xyc[1] - 1;
            int x2 = xyc[2] - 1;
            int y2 = xyc[3] - 1;
            int c = xyc[4];
            for (int j = x1; j <= x2; j++) {
                t[j][y1] += c;
                if (y2 + 1 < m) {
                    t[j][y2 + 1] -= c;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                t[i][j] += t[i][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] += t[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
