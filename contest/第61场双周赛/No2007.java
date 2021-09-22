package 第61场双周赛;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/22 09:11
 * @since 1.0
 **/
public class No2007 {

    /**
     * 从双倍数组中还原原数组
     *
     * @param changed
     * @return
     */
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len == 0 || len % 2 != 0) {
            return new int[]{};
        }
        int[] ans = new int[len / 2];
        Arrays.sort(changed);
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        int cnt = 0;
        for (int j : changed) {
            if (!map.containsKey(j * 2) || map.get(j) <= 0) {
                map.put(j, map.get(j) - 1);
            } else {
                map.put(j, map.get(j) - 1);
                if (map.get(j * 2) <= 0) {
                    return new int[]{};
                } else {
                    cnt++;
                    map.put(j * 2, map.get(j * 2) - 1);
                    ans[index++] = j;
                }
            }
        }
        return cnt == len / 2 ? ans : new int[]{};
    }
}
