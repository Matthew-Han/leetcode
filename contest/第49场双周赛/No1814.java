package 第49场双周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/3 22:29
 **/
public class No1814 {

    long mod = 1000000000 + 7;

    /**
     * #1814 统计一个数组中好对子的数目
     *
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        int ans = 0;
        int[] mem = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mem[i] = nums[i] - rev(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : mem) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (Integer value : map.values()) {
            if (value > 1) {
                ans += ((long) (value - 1) * value / 2) % mod;
            }
        }
        return ans;
    }

    public int rev(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

}
