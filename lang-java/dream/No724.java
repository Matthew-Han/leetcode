/**
 * @ClassName FindPivotIndex
 * @Description #724 寻找数组的中心索引
 * @Author MatthewHan
 * @Date 2020/6/4 01:46
 * @Version 1.0
 **/
public class No724 {


    /**
     * 1. 如果是纯正整数 或者 纯负整数，双指针还是可以的。不是的话暴力法可解。
     * 2. 「左求和 * 2 + 中心索引值 = 总和」，记住，i = 0 时，左求和 = 0，而且必须是从左向右，因为题目明确规定取最左边那一个。
     * 除非题目说取最右边那个，那么用「右求和 * 2 + 中心索引值 = 总和」，i = length -1 时，右求和 = 0，
     * 执行用时 : 436 ms , 在所有 Java 提交中击败了 15.24% 的用户
     * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 28.57% 的用户
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        for (int mid = 0; mid < len; mid++) {
            int leftSum = 0;
            for (int i = 0; i < mid; i++) {
                leftSum += nums[i];
            }
            int rightSum = 0;
            for (int i = mid + 1; i < len; i++) {
                rightSum += nums[i];
            }
            if (leftSum == rightSum) {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, -1, -1, 0, 1, 1}));
    }
}
