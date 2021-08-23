/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:40
 * @since 1.0
 **/
public class No1646 {

    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        int max = 1;
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = i % 2 == 0 ? nums[i / 2] : nums[i / 2] + nums[i / 2 + 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
