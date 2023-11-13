package 广度优先搜索;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName PondSizes
 * @Description 面试题 16.19. 水域大小
 * @Author MatthewHan
 * @Date 2020/8/3 16:34
 * @Version 1.0
 **/
public class M1619 {

    /**
     * 输入：
     * [
     * [0,2,1,0],
     * [0,1,0,1],
     * [1,1,0,1],
     * [0,1,0,1]
     * ]
     * 输出： [1,2,4]
     *
     * @param land
     * @return
     */
    public static int[] pondSizes(int[][] land) {
        boolean[][] visit = new boolean[land.length][land[0].length];

        List<Integer> res = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                tmp = bfs(land, visit, i, j);
                if (tmp != 0) {
                    res.add(tmp);
                }
            }

        }
        System.out.println("res = " + res);
        Collections.sort(res);
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static int bfs(int[][] land, boolean[][] visit, int x, int y) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || visit[x][y] || land[x][y] != 0) {
            return 0;
        }
        int sum = 1;
        visit[x][y] = true;
        sum += bfs(land, visit, x - 1, y - 1);
        sum += bfs(land, visit, x - 1, y);
        sum += bfs(land, visit, x - 1, y + 1);

        sum += bfs(land, visit, x, y - 1);
        sum += bfs(land, visit, x, y + 1);

        sum += bfs(land, visit, x + 1, y - 1);
        sum += bfs(land, visit, x + 1, y);
        sum += bfs(land, visit, x + 1, y + 1);
        return sum;
    }

    public static void main(String[] args) {
        pondSizes(new int[][]{{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}});
    }
}
