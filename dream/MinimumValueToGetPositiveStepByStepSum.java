/**
 * @ClassName MinimumValueToGetPositiveStepByStepSum
 * @Description #1413 逐步求和得到正数的最小值
 * @Author MatthewHan
 * @Date 2020/7/14 09:36
 * @Version 1.0
 **/
public class MinimumValueToGetPositiveStepByStepSum {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int minStartValue(int[] nums) {
        int index = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for (int i = 0; i <= index; i++) {
            curr += nums[i];
            min = Math.min(curr, min);
        }

        return min < 0 ? Math.abs(min - 1) : 1;
    }


    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-2, 1, -8, -2, 0}));
    }
}
