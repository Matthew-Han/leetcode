package dfs;

import java.util.*;

/**
 * @ClassName FriendCircles
 * @Description #547 朋友圈
 * @Author MatthewHan
 * @Date 2020/9/8 17:46
 * @Version 1.0
 **/
public class FriendCircles {

    /**
     * 执行用时： 43 ms , 在所有 Java 提交中击败了 5.84% 的用户
     * 内存消耗： 42.7 MB , 在所有 Java 提交中击败了 5.29% 的用户
     *
     * @param m
     * @return
     */
    public int findCircleNum(int[][] m) {
        Set<Set<Integer>> res = new HashSet<>();
        boolean[][] vis = new boolean[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (!vis[i][j] && m[i][j] == 1) {
                    Set<Integer> tmp = new HashSet<>();
                    dfs(tmp, m, i, j, vis);
                    res.add(tmp);
                }
            }
        }
        // res.remove(Collections.EMPTY_SET);
        System.out.println("res = " + res);
        return res.size();
    }

    public static void dfs(Set<Integer> tmp, int[][] m, int i, int j, boolean[][] vis) {
        if (i >= 0 && j >= 0 && i < m.length && j < m[0].length && !vis[i][j]) {
            vis[i][j] = true;
            if (m[i][j] == 1) {
                tmp.add(i);
                tmp.add(j);
                for (int k = 0; k < m.length; k++) {
                    dfs(tmp, m, i, k, vis);
                }
                for (int k = 0; k < m[0].length; k++) {
                    dfs(tmp, m, k, j, vis);
                }
            }
        }
    }


}
