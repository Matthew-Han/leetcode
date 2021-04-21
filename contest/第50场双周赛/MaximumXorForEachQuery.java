package 第50场双周赛;


/**
 * @author Matthew Han
 * @description
 * @date 2021/4/17 22:27
 * @since 1.0.0
 **/
public class MaximumXorForEachQuery {

    /**
     * #1829 每个查询的最大异或值
     *
     * @param nums
     * @param maximumBit
     * @return
     */
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans = new int[nums.length];
        int max = (int) Math.pow(2, maximumBit);
        int len = nums.length;
        int index = nums.length - 1;
        int prev = nums[0];
        int maxNum = Integer.MIN_VALUE;
        for (int j = 0; j < max; j++) {
            if ((prev ^ j) > maxNum) {
                maxNum = prev ^ j;
                ans[index] = j;
            }
        }
        index--;
        for (int i = 1; i < len; i++) {
            prev ^= nums[i];
            ans[index--] = maxNum ^ prev;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 2);
        System.out.println(3 ^ 2);
        System.out.println(3 ^ 1);
    }
}
