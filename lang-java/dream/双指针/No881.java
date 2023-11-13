package 双指针;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/26 11:01
 * @since 1.0
 **/
public class No881 {

    /**
     * 救生艇
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        for (int person : people) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        for (int i = people.length - 1; i >= 0; i--) {
            if (!map.containsKey(people[i]) || (map.containsKey(people[i]) && map.get(people[i]) < 1)) {
                continue;
            }
            if (map.get(people[i]) == 1) {
                map.remove(people[i]);
            } else {
                map.put(people[i], map.get(people[i]) - 1);
            }
            int k = limit - people[i];
            Integer target = map.ceilingKey(k);
            if (target != null && map.get(target) >= 1) {
                if (map.get(target) == 1) {
                    map.remove(target);
                } else {
                    map.put(target, map.get(target) - 1);
                }
            }
            ans++;
        }
        return ans;
    }
}
