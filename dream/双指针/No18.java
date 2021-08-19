package 双指针;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/19 17:17
 * @since 1.0
 **/
public class No18 {

    /**
     * 四数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Long, Integer> cache = new HashMap<>();
        Set<String> vis = new HashSet<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);

        }
        List<Integer> newNums = new ArrayList<>();
        // 经典去重, 最大取 4 个
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int limit = Math.min(e.getValue(), 4);
            while (limit-- > 0) {
                newNums.add(e.getKey());
            }
        }
        for (int i = 0; i < newNums.size(); i++) {
            cache.put((long) newNums.get(i), i);
        }
        for (int i = 0; i < newNums.size(); i++) {
            for (int j = 0; j < newNums.size(); j++) {
                for (int k = 0; k < newNums.size(); k++) {
                    if (i != j && j != k && i != k) {
                        long sum = newNums.get(i) + newNums.get(j) + newNums.get(k);
                        if (cache.containsKey(target - sum) && cache.get(target - sum) != i && cache.get(target - sum) != j && cache.get(target - sum) != k) {
                            List<Integer> t = Arrays.asList(newNums.get(i), newNums.get(j), newNums.get(k), (int) (target - sum));

                            Collections.sort(t);
                            if (vis.contains(t.toString())) {
                                continue;
                            }
                            vis.add(t.toString());
                            ans.add(t);
                        }
                    }
                }
            }
        }
        return ans;

    }
}
