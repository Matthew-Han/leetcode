package 双指针;

import java.util.*;

/**
 * @ClassName 双指针.TwoSumII
 * @Description #167 两数之和 II - 输入有序数组
 * @Author MatthewHan
 * @Date 2020/4/22 11:08
 * @Version 1.0
 **/
public class No167 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 97.92% 的用户
     * 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了 6.67% 的用户
     * 这个思想 + 双指针属实顶！
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {

        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            }
            if (numbers[low] + numbers[high] < target) {
                low++;
            }
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low + 1, high + 1};
            }
        }

        return null;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{0, 2, 7}, 7)));
    }
}
