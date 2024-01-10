import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2024/1/10 16:21:28
 **/
public class No911 {

    TreeMap<Integer, Integer> map;

    /**
     * 在线选举
     *
     * @param persons
     * @param times
     */
    public No911(int[] persons, int[] times) {
        map = new TreeMap<>();
        int len = persons.length;
        Map<Integer, Integer> sub = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sub.put(persons[i], sub.getOrDefault(persons[i], 0) + 1);
            List<Integer> maxPersons = maxPersons(sub);
            if (maxPersons.size() > 1) {
                map.put(times[i], check(maxPersons, persons, i));
            } else {
                map.put(times[i], maxPersons.get(0));
            }

        }


    }

    public List<Integer> maxPersons(Map<Integer, Integer> map) {
        List<Integer> ans = new ArrayList<>();
        List<int[]> sorted = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).map(x -> new int[]{x.getKey(), x.getValue()}).toList();
        ans.add(sorted.get(0)[0]);
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i)[1] == sorted.get(0)[1]) {
                ans.add(sorted.get(i)[0]);
            }
        }
        return ans;
    }

    public int check(List<Integer> maxPersons, int[] persons, int idx) {
        for (int i = idx; i >= 0; i--) {
            if (maxPersons.contains(persons[i])) {
                return persons[i];
            }
        }
        return -1;
    }

    public int q(int t) {
        return map.floorEntry(t).getValue();
    }

}
