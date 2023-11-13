package 二分查找;

import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/20 15:36 20
 * @since 1.0
 **/
public class No436 {

    /**
     * 寻找右区间
     *
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // Integer t = map.remove(curr[0]);
            Integer v = map.ceilingKey(curr[1]);
            if (v != null) {
                ans[i] = map.get(v);
            } else {
                ans[i] = -1;
            }
            // map.put(curr[0], t);
        }
        return ans;
    }
}
