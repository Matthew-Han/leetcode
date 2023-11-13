package 第244场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/7 15:45
 * @description
 * @since 1.0.0
 **/
public class No1887 {

    /**
     * #1887 使数组元素相等的减少操作次数
     *
     * @param nums
     * @return
     */
    public int reductionOperations(int[] nums) {
        int[] bucket = new int[50001];
        int min = 0x3f3f3f3f;
        for (int num : nums) {
            bucket[num]++;
            min = Math.min(min, num);
        }
        int ans = 0;

        int prev = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] > 0 && i != min) {
                ans += prev + bucket[i];
                prev += bucket[i];
            }
        }
        return ans;
    }
}
