/**
 * @ClassName MaximumAverageSubarrayI
 * @Description #643 子数组最大平均数 I
 * @Author MatthewHan
 * @Date 2020/5/22 21:55
 * @Version 1.0
 **/
public class MaximumAverageSubarrayI {

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 36.90% 的用户
     * 内存消耗 : 43.6 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {

        int i = 0;
        int j = i + k;
        double sum = 0;
        for (int n = 0; n < k; n++) {
            sum += nums[n];
        }
        double max = sum / k;
        while (j < nums.length) {
            sum = (sum - nums[i] + nums[j]);
            i++;
            j++;
            max = Math.max(max, sum / k);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
