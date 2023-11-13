import java.util.Arrays;

/**
 * @ClassName MinimumMovesToEqualArrayElementsII
 * @Description #462 最少移动次数使数组元素相等 II
 * @Author MatthewHan
 * @Date 2020/9/4 10:55
 * @Version 1.0
 **/
public class No462 {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 77.25% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 31.81% 的用户
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int c = nums[nums.length / 2];
        int count = 0;
        for (int num : nums) {
            count += Math.abs(num - c);
        }
        return count;
    }

}
