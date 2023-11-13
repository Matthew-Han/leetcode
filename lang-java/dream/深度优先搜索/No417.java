package 深度优先搜索;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/27 10:33 27
 * @since 1.0
 **/
public class No417 {

    boolean[][] pacific;
    boolean[][] atlantic;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    /**
     * 太平洋大西洋水流问题
     *
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        this.pacific = new boolean[heights.length][heights[0].length];
        this.atlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                dfs(i, j, new int[]{i, j}, heights, new boolean[heights.length][heights[0].length]);
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.addAll(new ArrayList(Collections.singletonList(new int[]{i, j})));
                }
            }
        }
        return ans;

    }


    public void dfs(int o1, int o2, int[] xy, int[][] heights, boolean[][] vis) {
        vis[xy[0]][xy[1]] = true;
        for (int i = 0; i < 4; i++) {
            int newX = xy[0] + dx[i];
            int newY = xy[1] + dy[i];
            if (newX < 0 || newY < 0) {
                pacific[o1][o2] = true;
            }
            if (newX > heights.length - 1 || newY > heights[0].length - 1) {
                atlantic[o1][o2] = true;
            }
            if (newX >= 0 && newY >= 0 && newX < heights.length && newY < heights[0].length && !vis[newX][newY] && heights[xy[0]][xy[1]] >= heights[newX][newY]) {
                vis[xy[0]][xy[1]] = true;
                dfs(o1, o2, new int[]{newX, newY}, heights, vis);
            }
        }
    }
}
