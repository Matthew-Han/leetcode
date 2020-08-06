package lcof;

import java.util.Arrays;

/**
 * @ClassName LcOf57
 * @Description 剑指 Offer #57 和为s的两个数字
 * @Author MatthewHan
 * @Date 2020/7/20 09:55
 * @Version 1.0
 **/
public class LcOf57 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 98.18% 的用户
     * 内存消耗： 57.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while (nums[i] + nums[j] != target) {
            if (nums[i] + nums[j] > target) {
                j--;
                // 为了减少i后退的步数，不用i = 0
                i = i > 0 ? i - 1 : 0;
            } else {
                i++;
            }
        }
        return new int[]{nums[i], nums[j]};
    }


    /**
     * 执行用时： 75 ms , 在所有 Java 提交中击败了 5.02% 的用户
     * 内存消耗： 62.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        boolean[] bucket = new boolean[1000000];
        for (int num : nums) {
            bucket[num] = true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] && bucket[target - i]) {
                return new int[]{i, target - i};
            }
        }
        return null;
    }

    /**
     * 超出时间限制
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int limit = right;
        while (left <= right) {
            limit = left + (right - left) / 2;
            if (nums[limit] >= target) {
                right = limit - 1;
            } else {
                left = limit + 1;
            }
            if (target <= nums[limit + 1 > nums.length - 1 ? limit : limit + 1] && target >= nums[Math.max(limit - 1, 0)]) {
                break;
            }
        }
        System.out.println("limit = " + limit);
        for (int i = 0; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum3(new int[]{16, 16, 18, 24, 30, 32}, 48)));
    }
}
