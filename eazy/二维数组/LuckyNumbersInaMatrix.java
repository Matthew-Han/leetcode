package 二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LuckyNumbersInaMatrix
 * @Description #1380 矩阵中的幸运数
 * @Author MatthewHan
 * @Date 2020/7/13 01:08
 * @Version 1.0
 **/
public class LuckyNumbersInaMatrix {


    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 26.93% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param matrix
     * @return
     */
    public static List<Integer> luckyNumbers(int[][] matrix) {

        int len = matrix[0].length;
        List<Integer> list = new ArrayList<>(len);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : matrix) {
                max = Math.max(max, ints[i]);
            }
            list.add(max);
        }
        for (int[] ints : matrix) {
            int min = Integer.MAX_VALUE;
            for (int anInt : ints) {
                min = Math.min(min, anInt);
            }
            if (list.remove((Integer) min)) {
                result.add(min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{8, 8, 8}, {5, 5, 9}}));
    }
}
