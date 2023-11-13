package 二分查找;

import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/8 09:39 08
 * @since 1.0
 **/
public class No2055 {


    /**
     * 蜡烛之间的盘子
     *
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int len = s.length();
        int[] l = new int[len];
        TreeSet<Integer> candle = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|') {
                candle.add(i);
            }
        }
        l[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            l[i] += l[i - 1] + (s.charAt(i) == '*' ? 1 : 0);
        }
        for (int i = 0; i < queries.length; i++) {
            Integer left = candle.ceiling(queries[i][0]);
            Integer right = candle.floor(queries[i][1]);
            if (left != null && right != null && left < right) {
                ans[i] = l[right] - l[left];
            }
        }
        return ans;

    }
}
