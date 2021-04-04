package 第235场周赛;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/5 02:34
 **/
public class FindingTheUsersActiveMinutes {

    /**
     * #5723 查找用户活跃分钟数
     * @param logs
     * @param k
     * @return
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set;
            if (!map.containsKey(log[0])) {
                set = new HashSet<>();
            } else {
                set = map.get(log[0]);
            }
            set.add(log[1]);
            map.put(log[0], set);
        }
        System.out.println(map);
        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            ans[e.getValue().size() - 1]++;
        }
        return ans;
    }
}
