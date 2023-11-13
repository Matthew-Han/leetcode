package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/8 14:33
 **/
public class No120 {


    /**
     * #120 三角形最小路径和
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 5.09% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 81.42% 的用户
     *
     * @param triangle
     * @return
     */
    public int dpGo(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        List<List<Integer>> dp = new ArrayList<>(triangle);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i > 0) {
                    int min;
                    if (j == 0) {
                        min = dp.get(i - 1).get(j);
                    } else if (j == triangle.get(i).size() - 1) {
                        min = dp.get(i - 1).get(j - 1);
                    } else {
                        min = Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j - 1));
                    }
                    List<Integer> tmp = dp.get(i);
                    tmp.set(j, min + triangle.get(i).get(j));
                    dp.set(i, tmp);
                }
            }
        }
        // System.out.println("dp = " + dp);
        List<Integer> last = dp.get(dp.size() - 1);
        for (Integer n : last) {
            res = Math.min(res, n);
        }
        return res;
    }


    int min = Integer.MAX_VALUE;

    /**
     * 超时
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0, 0);
        return min;
    }

    public void dfs(List<List<Integer>> triangle, int index, int depth, int v) {
        if (depth >= triangle.size()) {
            min = Math.min(min, v);
            return;
        }
        int tmp = triangle.get(depth).get(index);
        dfs(triangle, index, depth + 1, v + tmp);
        dfs(triangle, index + 1, depth + 1, v + tmp);

    }
}
