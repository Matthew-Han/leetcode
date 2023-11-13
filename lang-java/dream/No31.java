import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/12 23:52
 **/
public class No31 {

    /**
     * #31 下一个排列
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.68% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 90.41% 的用户
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        boolean flag = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i - 1 >= 0 && nums[i] > nums[i - 1]) {
                flag = false;
                int from = i - 1;
                int secondIndex = secondMaxNumberIndex(nums, from);
                // swap
                nums[i - 1] ^= nums[secondIndex];
                nums[secondIndex] ^= nums[i - 1];
                nums[i - 1] ^= nums[secondIndex];
                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
        if (flag) {
            Arrays.sort(nums);
        }
    }

    public int secondMaxNumberIndex(int[] nums, int from) {
        int secondMax = -1;
        int begin = nums[from];
        int[] tmp = new int[nums.length - from];
        System.arraycopy(nums, from, tmp, 0, tmp.length);
        Arrays.sort(tmp);
        for (int j : tmp) {
            if (j > begin) {
                secondMax = j;
                break;
            }
        }
        for (int i = from; i < nums.length; i++) {
            if (nums[i] == secondMax) {
                return i;
            }
        }
        return -1;
    }
}
