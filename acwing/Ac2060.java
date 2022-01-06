import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/4 15:11
 * @since 1.0
 **/
public class Ac2060 {

    static char[][] map;

    static int min;

    static int[] dx = {0, 0, -1, 1};

    static int[] dy = {-1, 1, 0, 0};

    /**
     * 奶牛选美
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        min = Integer.MAX_VALUE;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        map = new char[n][k];
        for (int i = 0; i < n; i++) {
            char[] line = sc.readLine().toCharArray();
            map[i] = line;
        }
        fuck:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (map[i][j] == 'X') {
                    dfs(map, i, j, new boolean[n][k]);
                    break fuck;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (map[i][j] == '$') {
                    min = Math.min(min, bfs(map, i, j));
                }
            }
        }
        System.out.println(min);

    }

    public static int bfs(char[][] map, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int step = -1;
        boolean[][] vis = new boolean[map.length][map[0].length];
        vis[x][y] = true;
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int[] curr = queue.poll();
                x = curr[0];
                y = curr[1];
                if (map[x][y] == 'X') {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length && !vis[newX][newY] && map[newX][newY] != '&') {
                        vis[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        return Integer.MAX_VALUE;
    }

    public static void dfs(char[][] map, int x, int y, boolean[][] vis) {
        map[x][y] = '$';
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length && !vis[newX][newY] && map[newX][newY] == 'X') {
                vis[newX][newY] = true;
                dfs(map, newX, newY, vis);
                vis[newX][newY] = false;
            }
        }
    }
}
