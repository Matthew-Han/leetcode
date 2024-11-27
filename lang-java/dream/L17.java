import java.util.Arrays;

/**
 * @ClassName LcOf17
 * @Description 剑指 Offer #17 打印从1到最大的n位数
 * @Author MatthewHan
 * @Date 2020/7/19 02:38
 * @Version 1.0
 **/
public class L17 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 47.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int max = switch (n) {
            case 2 -> 99;
            case 3 -> 999;
            case 4 -> 9999;
            case 5 -> 99999;
            case 6 -> 999999;
            case 7 -> 9999999;
            case 8 -> 99999999;
            case 9 -> 999999999;
            case 10 -> Integer.MAX_VALUE;
            default -> 9;
        };
        int[] result = new int[max];
        for (int i = 1; i <= max; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}
