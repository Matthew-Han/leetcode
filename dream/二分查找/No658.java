package 二分查找;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/8/25 17:00 25
 * @since 1.0
 **/
public class No658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        while (k-- > 0) {
            Map.Entry<Integer, Integer> ce = map.ceilingEntry(x);
            Map.Entry<Integer, Integer> fe = map.floorEntry(x);
            Map.Entry<Integer, Integer> fuck;
            if (ce == null) {
                fuck = fe;
            } else if (fe == null) {
                fuck = ce;
            } else {
                if (Math.abs(ce.getKey() - x) == Math.abs(fe.getKey() - x)) {
                    fuck = fe.getKey() <= ce.getKey() ? fe : ce;
                } else {
                    fuck = Math.abs(fe.getKey() - x) <= Math.abs(ce.getKey() - x) ? fe : ce;
                }
            }
            map.remove(fuck.getKey());
            if (fuck.getValue() != 1) {
                map.put(fuck.getKey(), fuck.getValue() - 1);
            }
            ans.add(fuck.getKey());
        }
        ans.sort(Comparator.comparingInt(o -> o));
        return ans;

    }

}
