package 剑指Offer;

import java.util.Arrays;

/**
 * @ClassName LcOf11
 * @Description 剑指 Offer #11 旋转数组的最小数字
 * @Author MatthewHan
 * @Date 2020/7/17 19:24
 * @Version 1.0
 **/
public class LcOf11 {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 43.61% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param numbers
     * @return
     */
    public int minArrayPro(int[] numbers) {
        int left = numbers[0];
        int right = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                right = numbers[i + 1];
            }
        }
        return Math.min(left, right);
    }


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 43.61% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

}
