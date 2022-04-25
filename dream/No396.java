import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/25 16:12 25
 * @since 1.0
 **/
public class No396 {


    /**
     * 旋转函数
     *
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        final int[] idx = {0};
        int sum = Arrays.stream(nums).sum();
        int ans = Arrays.stream(nums).flatMap(value -> IntStream.of(value * idx[0]++)).sum();
        int prev = ans;

        for (int i = nums.length - 1; i >= 0; i--) {
            prev -= nums[i] * (nums.length - 1);
            prev += sum - nums[i];
            ans = Math.max(ans, prev);
        }
        return ans;
    }
}
