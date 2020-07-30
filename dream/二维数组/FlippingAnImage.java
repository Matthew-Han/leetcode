package 二维数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName 二维数组.FlippingAnImage
 * @Description #832 翻转图像
 * @Author MatthewHan
 * @Date 2019/8/8 15:40
 * @Version 1.0
 **/
public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0}, {1, 0, 1, 0}, {1, 1, 1, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImagePro(arr)));


        String[] ff = {"s", "s", "dd"};
        System.out.println(Arrays.toString(ff));
    }


    /**
     * 时隔10个月
     * 从简单一直刷到了当时随机做的一题
     * 看了看当初的代码
     * 现在的我写的更简洁、更高效了
     * 希望今后下一次review以前的代码的时候
     * 能够从心里发出一声
     * 「哇，2020年的我，代码写的这么弱啊！」
     * <p>
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 57.22% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 13.33% 的用户
     *
     * @param arr
     * @return
     */
    private static int[][] flipAndInvertImagePro(int[][] arr) {
        int x = arr.length;
        int y = arr[0].length;
        for (int i = 0; i < x; i++) {
            int j = 0;
            int k = y - 1;
            while (j < k) {
                int temp = arr[i][k];
                arr[i][k] = arr[i][j];
                arr[i][j] = temp;
                j++;
                k--;
            }
            for (int n = 0; n < y; n++) {
                arr[i][n] = arr[i][n] == 0 ? 1 : 0;
            }
        }
        return arr;
    }


    /**
     * 垃圾中垃圾代码，真的是全靠猥琐实现.
     *
     * @param arr
     * @return
     */
    private static int[][] flipAndInvertImage(int[][] arr) {

        List<int[]> result = new ArrayList<>(16);
        for (int[] anArr : arr) {
            StringBuilder sb = new StringBuilder();
            StringBuilder str = new StringBuilder();
            for (int a : anArr) {
                str.append(a);
            }
            str.reverse();
            System.out.println(str);
            String[] ss = str.toString().split("");
            StringBuilder str2 = new StringBuilder();
            for (String s : ss) {
                if (Integer.parseInt(s) == 0) {
                    str2.append(1);
                } else if (Integer.parseInt(s) == 1) {
                    str2.append(0);
                }
            }
            sb.append(str2);
            String[] is = sb.toString().split("");
            result.add(stringToInt(is));
        }
        return result.toArray(new int[0][]);

    }

    private static int[] stringToInt(String[] arrs) {
        int[] ints = new int[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            ints[i] = Integer.parseInt(arrs[i]);
        }
        return ints;
    }


}
