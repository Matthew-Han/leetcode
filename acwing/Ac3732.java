import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/30 19:21
 * @since 1.0
 **/
public class Ac3732 {


    /**
     * 矩阵复原
     * <p>
     * 原先用的一维数组作为缓存无限超时
     * 后来用了 HashMap 就 accept 了，可能是初始化容量太大了？随机访问反而会很慢。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        while (k-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] mat1 = new int[n][m];
            int[][] mat2 = new int[m][n];
            // int[] cache = new int[250001];
            Map<Integer, Integer> map = new HashMap<>();
            int[][] res = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat1[i][j] = sc.nextInt();
                    // cache[mat1[i][j]] = j;
                    map.put(mat1[i][j], j);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    mat2[i][j] = sc.nextInt();
                    // res[j][cache[mat2[i][j]]] = mat2[i][j];
                    res[j][map.get(mat2[i][j])] = mat2[i][j];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.setLength(0);
                for (int j = 0; j < m; j++) {
                    sb.append(res[i][j]).append(" ");
                }
                System.out.println(sb.toString());
            }


        }
    }
}
