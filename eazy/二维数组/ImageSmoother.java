package 二维数组;

import java.util.Arrays;


/**
 * @ClassName 二维数组.ImageSmoother
 * @Description #661 图片平滑器
 * @Author MatthewHan
 * @Date 2020/5/23 18:10
 * @Version 1.0
 **/
public class ImageSmoother {

    /**
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 80.81% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 71.43% 的用户
     *
     * @param M
     * @return
     */
    public static int[][] imageSmootherPro(int[][] M) {
        int sec = M.length;
        int fir = M[0].length;
        int[][] ints = new int[sec][fir];
        for (int i = 0; i < sec; i++) {
            for (int j = 0; j < fir; j++) {
                int self = M[i][j];
                int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0;
                int count = 1;
                // 左上
                if (i >= 1 && j >= 1) {
                    a = M[i - 1][j - 1];
                    System.out.println("a = " + a);
                    count++;
                }
                // 正上
                if (i >= 1) {
                    b = M[i - 1][j];
                    System.out.println("b = " + b);
                    count++;
                }
                // 右上
                if (i >= 1 && j + 1 < fir) {
                    c = M[i - 1][j + 1];
                    System.out.println("c = " + c);
                    count++;
                }
                // 正左
                if (j >= 1) {
                    d = M[i][j - 1];
                    System.out.println("d = " + d);
                    count++;
                }
                // 正右
                if (j + 1 < fir) {
                    e = M[i][j + 1];
                    System.out.println("e = " + e);
                    count++;
                }
                // 左下
                if (i + 1 < sec && j >= 1) {
                    f = M[i + 1][j - 1];
                    System.out.println("f = " + f);
                    count++;
                }
                // 正下
                if (i + 1 < sec) {
                    g = M[i + 1][j];
                    System.out.println("g = " + g);
                    count++;
                }
                // 右下
                if (i + 1 < sec && j + 1 < fir) {
                    h = M[i + 1][j + 1];
                    System.out.println("h = " + h);
                    count++;
                }
                System.out.println(self + a + b + c + d + e + f + g + h);
                System.out.println(count);
                System.out.println("-------------");
                ints[i][j] = (self + a + b + c + d + e + f + g + h) / count;
            }
        }


        return ints;
    }

    /**
     * 我哭了，我以为只有0和1，当二维数组只有0和1的时候可用如下算法。
     *
     * @param M
     * @return
     */
    public static int[][] imageSmoother(int[][] M) {
        int sec = M.length;
        int fir = M[0].length;
        for (int i = 0; i < sec; i++) {
            for (int j = 0; j < fir; j++) {
                if (M[i][j] == 0) {
                    // 左上
                    if (i >= 1 && j >= 1) {
                        M[i - 1][j - 1] = M[i - 1][j - 1] == 0 ? 0 : 2;
                    }
                    // 正上
                    if (i >= 1) {
                        M[i - 1][j] = M[i - 1][j] == 0 ? 0 : 2;
                    }
                    // 右上
                    if (i >= 1 && j + 1 < fir) {
                        M[i - 1][j + 1] = M[i - 1][j + 1] == 0 ? 0 : 2;
                    }
                    // 正左
                    if (j >= 1) {
                        M[i][j - 1] = M[i][j - 1] == 0 ? 0 : 2;
                    }
                    // 正右
                    if (j + 1 < fir) {
                        M[i][j + 1] = M[i][j + 1] == 0 ? 0 : 2;
                    }
                    // 左下
                    if (i + 1 < sec && j >= 1) {
                        M[i + 1][j - 1] = M[i + 1][j - 1] == 0 ? 0 : 2;
                    }
                    // 正下
                    if (i + 1 < sec) {
                        M[i + 1][j] = M[i + 1][j] == 0 ? 0 : 2;
                    }
                    // 右下
                    if (i + 1 < sec && j + 1 < fir) {
                        M[i + 1][j + 1] = M[i + 1][j + 1] == 0 ? 0 : 2;
                    }

                }
            }
        }
        System.out.println(Arrays.deepToString(M));
        for (int i = 0; i < sec; i++) {
            for (int j = 0; j < fir; j++) {
                M[i][j] = M[i][j] == 2 ? 0 : M[i][j];
            }
        }
        return M;

    }




    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(imageSmootherPro(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}})));
    }
}
