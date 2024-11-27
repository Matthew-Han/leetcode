import java.util.Arrays;

/**
 * @ClassName MinimumMovesToEqualArrayElements
 * @Description #453 最小移动次数使数组元素相等
 * @Author MatthewHan
 * @Date 2020/5/15 14:19
 * @Version 1.0
 **/
public class No453 {

    /**
     * n-1 个数同时加一，就好比每次有 1 个数自身减一，因为只能做减法，所以数组最后的数只能是最小值。
     * 这样的话每个元素减去最小值求其和就是答案。小小菜鸟，博君一笑！
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        return Arrays.stream(nums).sum() - nums.length * Arrays.stream(nums).min().orElse(0);
    }


    /**
     * 执行用时 : 14 ms , 在所有 Java 提交中击败了 29.26% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int law(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int po = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            count += (nums[i + 1] - nums[i]) * po;
            po--;
        }
        return count;
    }
}