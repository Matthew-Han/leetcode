package 剑指Offer;

import java.util.Arrays;

/**
 * @ClassName LcOf61
 * @Description 剑指 Offer #61 扑克牌中的顺子
 * @Author MatthewHan
 * @Date 2020/7/22 09:55
 * @Version 1.0
 **/
public class LcOf61 {

    /**
     * Problem Description:
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 89.50% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        int diff = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != 0 && nums[i - 1] != 0) {
                // 除了大小王，相同的数字为false
                if (nums[i] == nums[i - 1]) {
                    return false;
                }
                diff += nums[i] - nums[i - 1];
            }
        }
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }
        int notZero = nums.length - zeroCount;
        if (notZero == 1) {
            return true;
        } else if (notZero == 2 || notZero == 3 || notZero == 4) {
            return diff <= 4;
        }
        return diff == 4;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0, 3, 2, 6, 5}));
    }
}
