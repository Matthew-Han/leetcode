package 秋季编程大赛2021;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/14 10:23
 * @since 1.0
 **/
public class Lcp39 {

    /**
     * 无人机方阵
     *
     * @param source
     * @param target
     * @return
     */
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> sMap = new HashMap<>();
        for (int[] ints : source) {
            for (int i : ints) {
                sMap.put(i, sMap.getOrDefault(i, 0) + 1);
            }
        }
        Map<Integer, Integer> tMap = new HashMap<>();
        for (int[] ints : target) {
            for (int i : ints) {
                tMap.put(i, tMap.getOrDefault(i, 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
            int tSum = entry.getValue();
            if (sMap.containsKey(entry.getKey())) {
                ans += Math.max(tSum - sMap.get(entry.getKey()), 0);
            } else {
                ans += entry.getValue();
            }
        }
        return ans;
    }
}

