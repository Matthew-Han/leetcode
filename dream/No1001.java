import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/9 00:13 09
 * @since 1.0
 **/
public class No1001 {

    /**
     * 网格照明
     * <p>
     * 和官解差不多，难点就是判断 queries 里的坐标是否在光路上以及以下
     * <p>
     * 0. 删除所在灯泡
     * <p>
     * 1. 初始化记得灯泡去重
     * <p>
     * 2. 记得当前坐标可能也存在灯泡需要删除
     * <p>
     * 这些细节就好了。
     *
     * @param n
     * @param lamps
     * @param queries
     * @return
     */
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[][] dxy = new int[][]{{0, 0, 0, -1, -1, -1, 1, 1, 1}, {-1, 1, 0, 0, 1, -1, 0, 1, -1}};
        Set<String> vis = new HashSet<>();
        int[] ans = new int[queries.length];
        Map<Integer, Integer> xSet = new HashMap<>();
        Map<Integer, Integer> ySet = new HashMap<>();
        Map<Integer, Integer> leftSet = new HashMap<>();
        Map<Integer, Integer> rightSet = new HashMap<>();
        for (int[] lamp : lamps) {
            if (vis.contains(lamp[0] + " " + lamp[1])) {
                continue;
            }
            vis.add(lamp[0] + " " + lamp[1]);
            xSet.put(lamp[0], xSet.getOrDefault(lamp[0], 0) + 1);
            ySet.put(lamp[1], ySet.getOrDefault(lamp[1], 0) + 1);
            leftSet.put(lamp[0] + lamp[1], leftSet.getOrDefault(lamp[0] + lamp[1], 0) + 1);
            rightSet.put(lamp[0] - lamp[1], rightSet.getOrDefault(lamp[0] - lamp[1], 0) + 1);
        }
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (xSet.containsKey(x) || ySet.containsKey(y) || leftSet.containsKey(x + y) || rightSet.containsKey(x - y)) {
                ans[i] = 1;
                for (int j = 0; j < 9; j++) {
                    int newX = x + dxy[0][j];
                    int newY = y + dxy[1][j];

                    if (newX >= 0 && newY >= 0 && newX < n && newY < n && vis.contains(newX + " " + newY)) {

                        if (xSet.get(newX) == 1) {
                            xSet.remove(newX);
                        } else {
                            xSet.put(newX, xSet.get(newX) - 1);
                        }

                        if (ySet.get(newY) == 1) {
                            ySet.remove(newY);
                        } else {
                            ySet.put(newY, ySet.get(newY) - 1);
                        }

                        if (leftSet.get(newX + newY) == 1) {
                            leftSet.remove(newX + newY);
                        } else {
                            leftSet.put(newX + newY, leftSet.get(newX + newY) - 1);
                        }

                        if (rightSet.get(newX - newY) == 1) {
                            rightSet.remove(newX - newY);
                        } else {
                            rightSet.put(newX - newY, rightSet.get(newX - newY) - 1);
                        }
                        vis.remove(newX + " " + newY);
                    }
                }
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}
