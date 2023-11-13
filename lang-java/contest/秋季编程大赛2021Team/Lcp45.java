package 秋季编程大赛2021Team;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/26 15:27
 * @since 1.0
 **/
public class Lcp45 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    List<int[]> ans;
    Set<String> mem;
    boolean[][] global;
    int[] p;

    /**
     * 自行车炫技赛场
     *
     * @param position
     * @param terrain
     * @param obstacle
     * @return
     */
    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        ans = new ArrayList<>();
        mem = new HashSet<>();
        global = new boolean[terrain.length][terrain[0].length];
        p = position;
        bfs(1, position[0], position[1], terrain, obstacle);
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        Arrays.sort(res, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        return res;
    }

    public void bfs(int curr, int x, int y, int[][] terrain, int[][] obstacle) {
        if (x >= 0 && y >= 0 && x < terrain.length && y < terrain[0].length) {
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < terrain.length && newY < terrain[0].length) {
                    int next = curr + terrain[x][y] - terrain[newX][newY] - obstacle[newX][newY];
                    // i, j, v 作为唯一 key
                    String k = newX + "-" + newY + "-" + next;
                    if (mem.contains(k)) {
                        continue;
                    }
                    mem.add(k);
                    if (next >= 1) {
                        if (next == 1 && (newX != p[0] || newY != p[1]) && !global[newX][newY]) {
                            global[newX][newY] = true;
                            ans.add(new int[]{newX, newY});
                        }
                        bfs(next, newX, newY, terrain, obstacle);
                    }
                }
            }
        }
    }
}

