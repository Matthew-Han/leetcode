import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/30 15:27
 **/
public class L56 {

    /**
     * 剑指 Offer #56 - II 数组中数字出现的次数 II
     * 执行用时： 19 ms , 在所有 Java 提交中击败了 10.00% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 6.82% 的用户
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
