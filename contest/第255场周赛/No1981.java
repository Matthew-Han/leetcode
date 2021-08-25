package 第255场周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:44
 * @since 1.0
 **/
public class No1981 {

    Map<Integer, Set<Integer>> map;
    int ans = 0x3f3f3f3f;

    /**
     * 记忆化递归
     * <p>
     * 最小化目标值与所选元素的差
     *
     * @param mat
     * @param target
     * @return
     */
    public int minimizeTheDifference(int[][] mat, int target) {
        map = new HashMap<>();
        for (int[] ints : mat) {
            Arrays.sort(ints);
        }
        dfs(mat, target, 0, 0);
        return ans;
    }

    public void dfs(int[][] mat, int target, int curr, int step) {
        if (step >= mat.length) {
            ans = Math.min(Math.abs(target - curr), ans);
            return;
        }
        for (int i = 0; i < mat[0].length; i++) {
            if (curr + mat[step][i] - target > ans) {
                break;
            }
            if (map.get(step) != null && map.get(step).contains(curr + mat[step][i])) {
                continue;
            }
            map.put(step, map.getOrDefault(step, new HashSet<>()));
            map.get(step).add(curr + mat[step][i]);
            dfs(mat, target, curr + mat[step][i], step + 1);
        }
    }
}
