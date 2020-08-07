package 双指针;

import java.util.*;

/**
 * @ClassName 双指针.KdiffPairsInAnArray
 * @Description #532 数组中的K-diff数对
 * @Author MatthewHan
 * @Date 2020/5/20 13:08
 * @Version 1.0
 **/
public class KdiffPairsInAnArray {

    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 85.71% 的用
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0, count = 0, prev = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[start] > k || prev == nums[start]) {
                if (++start != i) {
                    i--;
                }
            } else if (nums[i] - nums[start] == k) {
                prev = nums[start++];
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1, 1, 1, 2, 1}, 1));
        System.out.println(findPairs(new int[]{21, 11, 21, 11}, 10));
    }
}
