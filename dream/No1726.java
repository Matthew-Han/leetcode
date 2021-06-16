import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/22 10:54
 **/
public class No1726 {


    /**
     * #1726 同积元组
     * 执行用时： 466 ms , 在所有 Java 提交中击败了 24.92% 的用户
     * 内存消耗： 68.8 MB , 在所有 Java 提交中击败了 59.79% 的用户
     *
     * @param nums
     * @return
     */
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = nums[i] * nums[j];
                cache.put(k, cache.getOrDefault(k, 0) + 1);
            }
        }

        for (Integer k : cache.keySet()) {
            Integer v = cache.get(k);
            if (v > 1) {
                ans += (v - 1) * v * 4;
            }
        }
        return ans;
    }

}
