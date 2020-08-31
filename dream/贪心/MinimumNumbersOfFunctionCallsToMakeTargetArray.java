package 贪心;

import java.util.Arrays;

/**
 * @ClassName MinimumNumbersOfFunctionCallsToMakeTargetArray
 * @Description #1558 得到目标数组的最少函数调用次数
 * @Author MatthewHan
 * @Date 2020/8/31 09:55
 * @Version 1.0
 **/
public class MinimumNumbersOfFunctionCallsToMakeTargetArray {
    int count = 0;

    /**
     * 执行用时： 42 ms , 在所有 Java 提交中击败了 70.14% 的用户
     * 内存消耗： 47.6 MB , 在所有 Java 提交中击败了 91.19% 的用户
     *
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        while (true) {
            func1(nums);
            if (func2(nums)) {
                return count;
            }
        }

    }

    public void func1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) != 0) {
                count++;
                nums[i]--;
            }
        }

    }

    public boolean func2(int[] nums) {
        if (check(nums)) {
            count++;
            for (int i = 0; i < nums.length; i++) {
                nums[i] /= 2;
            }
            return false;
        } else {
            return true;
        }

    }

    public boolean check(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumNumbersOfFunctionCallsToMakeTargetArray mmm = new MinimumNumbersOfFunctionCallsToMakeTargetArray();
        System.out.println(mmm.minOperations(new int[]{1, 5}));
    }
}
