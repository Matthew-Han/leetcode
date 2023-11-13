/**
 * @ClassName LongestContinuousIncreasingSubsequence
 * @Description #674 最长连续递增序列
 * @Author MatthewHan
 * @Date 2020/5/23 22:54
 * @Version 1.0
 **/
public class No674 {

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 52.14% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 12.50% 的用户
     *
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < len && nums[i + 1] > nums[i]) {
                count++;

            }
            if (i + 1 < len && nums[i + 1] <= nums[i]) {
                max = Math.max(count, max);
                count = 1;
            }
            if (i == len - 1) {
                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 4, 3, 5, 7}));
    }
}
