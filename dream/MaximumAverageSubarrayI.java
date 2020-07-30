/**
 * @ClassName MaximumAverageSubarrayI
 * @Description #643 子数组最大平均数 I
 * @Author MatthewHan
 * @Date 2020/5/22 21:55
 * @Version 1.0
 **/
public class MaximumAverageSubarrayI {

    /**
     * 两个优化点：
     * 1. 不要把k个数字的和算好后，下一轮循环又置0。利用滑动窗口双指针，下一次循环是这次的和减去这组的头元素加上next指针的元素（需要防御下标溢出）；
     * 2. 平均数最后结果求就可以，不要每次都算出平均数然后比较较大值。（这点如果做了能优化很多）
     * <p>
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 75.97% 的用户
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
        double max = sum;
        while (j < nums.length) {
            sum = (sum - nums[i] + nums[j]);
            i++;
            j++;
            max = Math.max(max, sum);
        }
        return max / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1, 3, 5, 6, 72, 123, 124, 1, 2, 3}, 4));
    }
}
