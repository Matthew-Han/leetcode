package 深度优先搜索;

import 默认模板.QuadTree;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/29 11:16 29
 * @since 1.0
 **/
public class No427 {

    int[][] grid;

    /**
     * 建立四叉树
     *
     * @param grid
     * @return
     */
    public QuadTree construct(int[][] grid) {
        this.grid = grid;
        return dfs(new int[]{0, grid.length}, new int[]{0, grid[0].length});

    }

    public QuadTree dfs(int[] dx, int[] dy) {
        boolean[] v = check(dx, dy);
        return v[1] ? new QuadTree(v[0], true) : new QuadTree(v[0], false
                , dfs(new int[]{dx[0], (dx[1] + dx[0]) / 2}, new int[]{dy[0], (dy[1] + dy[0]) / 2})
                , dfs(new int[]{dx[0], (dx[1] + dx[0]) / 2}, new int[]{(dy[1] + dy[0]) / 2, dy[1]})
                , dfs(new int[]{(dx[1] + dx[0]) / 2, dx[1]}, new int[]{dy[0], (dy[1] + dy[0]) / 2})
                , dfs(new int[]{(dx[1] + dx[0]) / 2, dx[1]}, new int[]{(dy[1] + dy[0]) / 2, dy[1]}));

    }

    /**
     * check
     *
     * @param dx
     * @param dy
     * @return val, isLeaf
     */
    public boolean[] check(int[] dx, int[] dy) {
        int diff = grid[dx[0]][dy[0]];
        for (int i = dx[0]; i < dx[1]; i++) {
            for (int j = dy[0]; j < dy[1]; j++) {
                if (diff != grid[i][j]) {
                    return new boolean[]{true, false};
                }
            }
        }
        return new boolean[]{grid[dx[0]][dy[0]] == 1, true};
    }
}
