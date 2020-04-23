package leetcode.eazy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoNum
 * @Description #1 两数之和
 * @Author MatthewHan
 * @Date 2019/8/5 15:45
 * @Version 1.0
 **/
public class TwoSum {

    /**
     * 最蠢方法，最容易想到
     * 缺点：效率低
     * 其实有个核心要点就是题目中的：你不能重复利用这个数组中同样的元素。
     * 所以在相加的判断过程中，两个元素下标不能一致
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if ((nums[i] + nums[j]) == target && i != j) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }

    /**
     * 利用哈希映射
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
