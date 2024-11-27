import java.util.Arrays;

/**
 * @ClassName LcOf66
 * @Description 剑指 Offer #66 构建乘积数组
 * @Author MatthewHan
 * @Date 2020/7/23 09:25
 * @Version 1.0
 **/
public class L66 {

    /**
     * 空间换时间
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 82.77% 的用户
     * 内存消耗： 52.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a) {
        int len = a.length;
        int[] tempLeft = new int[len];
        int[] tempRight = new int[len];

        int prev = 1;
        for (int i = 0; i < len; i++) {
            tempLeft[i] = prev * a[i];
            prev = tempLeft[i];
        }
        prev = 1;
        for (int i = len - 1; i >= 0; i--) {
            tempRight[i] = prev * a[i];
            prev = tempRight[i];
        }
        for (int i = 0; i < len; i++) {
            int temp = 1;
            if (i - 1 >= 0) {
                temp *= tempLeft[i - 1];
            }
            if (i + 1 < len) {
                temp *= tempRight[i + 1];
            }
            a[i] = temp;
        }

        return a;

    }

}
