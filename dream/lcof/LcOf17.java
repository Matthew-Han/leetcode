package lcof;

import java.util.Arrays;

/**
 * @ClassName LcOf17
 * @Description 剑指 Offer #17 打印从1到最大的n位数
 * @Author MatthewHan
 * @Date 2020/7/19 02:38
 * @Version 1.0
 **/
public class LcOf17 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 47.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int max;
        switch (n) {
            case 2:
                max = 99;
                break;
            case 3:
                max = 999;
                break;
            case 4:
                max = 9999;
                break;
            case 5:
                max = 99999;
                break;
            case 6:
                max = 999999;
                break;
            case 7:
                max = 9999999;
                break;
            case 8:
                max = 99999999;
                break;
            case 9:
                max = 999999999;
                break;
            case 10:
                max = Integer.MAX_VALUE;
                break;
            default:
                max = 9;
                break;
        }
        int[] result = new int[max];
        for (int i = 1; i <= max; i++) {
            result[i - 1] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(6)));
    }

}
