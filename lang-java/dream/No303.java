import java.util.Arrays;

/**
 * @ClassName RangeSumQueryImmutable
 * @Description #303 区域和检索 - 数组不可变
 * @Author MatthewHan
 * @Date 2020/5/8 16:52
 * @Version 1.0
 **/
public class No303 {

    private final int[] sums;

    /**
     * 利用一个额外数组来存储i下标为之前的所有元素到下标i-1的总和，比如数组[1,2,3,4]，额外数组则为[0,1,3,6,10]
     * 求某个闭区间
     * 如：求下标(0, 2)的总和，则为额外数组的下标3 - 下标0的值。
     * 如：求下标(3, 3)的总和，则为额外数组的下标4 - 下标3的值。
     * <p>
     * 执行用时 : 10 ms , 在所有 Java 提交中击败了 99.42% 的用户
     * 内存消耗 : 42.1 MB , 在所有 Java 提交中击败了 56.52% 的用户
     *
     * @param nums
     */
    public No303(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

}
