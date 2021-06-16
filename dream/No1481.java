import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Matthew Han
 * @date 2021/5/10 10:43
 * @description
 * @since 1.0.0
 **/
public class No1481 {

    /**
     * #1481 不同整数的最少数目
     *
     * @param arr
     * @param k
     * @return
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Integer::compare);
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int ans = 0;
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort((o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < list.size(); i++) {
            if (k >= list.get(i)[1]) {
                k -= list.get(i)[1];
            } else {
                return list.size() - i;
            }
        }
        return ans;
    }
}
