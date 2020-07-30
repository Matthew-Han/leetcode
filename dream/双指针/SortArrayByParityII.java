package 双指针;

import java.util.Arrays;

/**
 * @ClassName 双指针.SortArrayByParityII
 * @Description #922 按奇偶排序数组 II
 * @Author MatthewHan
 * @Date 2020/6/23 16:27
 * @Version 1.0
 **/
public class SortArrayByParityII {

    /**
     * 原地双指针
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 35.69% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 63.64% 的用户
     *
     * @param arr
     * @return
     */
    public static int[] sortArrayByParityII(int[] arr) {
        // arr的长度最小是2
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length) {
            int odd = arr[i];
            int even = arr[j];
            if ((arr[i] & 1) != 0 && (arr[j] & 1) == 0) {
                arr[i] = even;
                arr[j] = odd;
                i += 2;
                j += 2;
            }
            if (i < arr.length && (arr[i] & 1) == 0) {
                i += 2;
            }
            if (j < arr.length && (arr[j] & 1) != 0) {
                j += 2;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{0, 0, 1, 8, 0, 1, 1, 2, 3, 5})));
        System.out.println((0 & 1) == 0);
    }
}
