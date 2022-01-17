package 设计题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/17 09:20
 * @since 1.0
 **/
public class No398 {

    Map<Integer, List<Integer>> map;


    /**
     * 随机数索引
     *
     * @param nums
     */
    public No398(int[] nums) {
        this.map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            this.map.put(nums[i], this.map.getOrDefault(nums[i], new ArrayList<>()));
            this.map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> v = this.map.get(target);
        int ans = 1000;
        int size = 1;
        for (int i = 0; i < v.size(); i++) {
            if (ThreadLocalRandom.current().nextInt(i + 1) == 0) {
                ans = v.get(i);
            }
        }
        return ans;
    }
}
