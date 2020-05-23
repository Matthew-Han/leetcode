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
        System.out.println(Arrays.deepToString(flipAndInvertImage(arr)));


        String[] ff = {"s", "s", "dd"};
        System.out.println(Arrays.toString(ff));
    }

    /**
     * @param arr arr辣
     * @return {int[][]}
     * @description 垃圾中垃圾代码，真的是全靠猥琐实现。。
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
