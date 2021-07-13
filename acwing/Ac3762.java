import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/13 11:20
 * @since 1.0
 **/
public class Ac3762 {

    /**
     * 二进制矩阵
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            char[][] fuck = new char[x][y];
            for (int i = 0; i < x; i++) {
                fuck[i] = sc.nextLine().toCharArray();
            }
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (fuck[i][j] == '1') {

                        int[][] cache = new int[4][2];
                        // step0
                        cache[0] = new int[]{i, j};
                        // step1
                        if (i + 1 < x) {
                            cache[1] = new int[]{i + 1, j};
                        } else {
                            cache[1] = new int[]{i - 1, j};
                        }
                        // step2
                        if (j + 1 < y) {
                            cache[2] = new int[]{i, j + 1};
                        } else {
                            cache[2] = new int[]{i, j - 1};
                        }
                        // step3
                        if (i + 1 < x && j + 1 < y) {
                            cache[3] = new int[]{i + 1, j + 1};
                        } else if (i + 1 < x && j - 1 >= 0) {
                            cache[3] = new int[]{i + 1, j - 1};
                        } else if (i - 1 >= 0 && j + 1 < y) {
                            cache[3] = new int[]{i - 1, j + 1};
                        } else {
                            cache[3] = new int[]{i - 1, j - 1};
                        }

                        StringBuilder sb = new StringBuilder();

                        sb.append(cache[0][0] + 1).append(" ").append(cache[0][1] + 1).append(" ");
                        sb.append(cache[1][0] + 1).append(" ").append(cache[1][1] + 1).append(" ");
                        sb.append(cache[2][0] + 1).append(" ").append(cache[2][1] + 1).append(" ");
                        ans.add(sb.toString());
                        sb.setLength(0);

                        sb.append(cache[0][0] + 1).append(" ").append(cache[0][1] + 1).append(" ");
                        sb.append(cache[1][0] + 1).append(" ").append(cache[1][1] + 1).append(" ");
                        sb.append(cache[3][0] + 1).append(" ").append(cache[3][1] + 1).append(" ");
                        ans.add(sb.toString());
                        sb.setLength(0);

                        sb.append(cache[0][0] + 1).append(" ").append(cache[0][1] + 1).append(" ");
                        sb.append(cache[2][0] + 1).append(" ").append(cache[2][1] + 1).append(" ");
                        sb.append(cache[3][0] + 1).append(" ").append(cache[3][1] + 1).append(" ");
                        ans.add(sb.toString());
                    }
                }
            }
            System.out.println(ans.size());
            for (String xy : ans) {
                System.out.println(xy);
            }
        }
    }
}
