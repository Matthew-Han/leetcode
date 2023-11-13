package 第262场周赛;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/11 10:26
 * @since 1.0
 **/
public class No2033 {

    /**
     * 获取单值网格的最小操作数
     *
     * @param grid
     * @param x
     * @return
     */
    public int minOperations(int[][] grid, int x) {
        int ans = 0;
        int len = grid.length * grid[0].length;
        List<Integer> tmp = new ArrayList<>();
        for (int[] g : grid) {
            for (int i : g) {
                tmp.add(i);
            }
        }
        Collections.sort(tmp);
        int z = tmp.get(len / 2);
        for (Integer t : tmp) {
            if (Math.abs(t - z) % x != 0) {
                return -1;
            } else {
                ans += Math.abs(t - z) / x;
            }
        }
        return ans;
    }
}
