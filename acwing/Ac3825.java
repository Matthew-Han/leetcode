import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/1 10:56
 * @since 1.0
 **/
public class Ac3825 {

    static Queue<int[]> q;
    static int[] dx;
    static int[] dy;
    static boolean[][] vis;
    static int maxDist;
    static int ans;

    /**
     * 逃离大森林
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        char[][] mat = new char[r][c];
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < r; i++) {
            mat[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        q = new LinkedList<>();
        dx = new int[]{0, 0, -1, 1};
        dy = new int[]{-1, 1, 0, 0};
        vis = new boolean[mat.length][mat[0].length];
        maxDist = 0x3f3f3f3f;
        ans = 0;

        dist(endX, endY, mat);
        System.out.println(ans);
    }

    public static void dist(int x, int y, char[][] mat) {

        q.offer(new int[]{x, y});
        int dist = 0;
        while (!q.isEmpty()) {
            int limit = q.size();
            while (limit-- > 0) {
                int[] curr = q.poll();
                if (mat[curr[0]][curr[1]] == 'S') {
                    maxDist = dist;
                }
                if (dist > maxDist) {
                    return;
                }
                if (Character.isDigit(mat[curr[0]][curr[1]])) {
                    ans += mat[curr[0]][curr[1]] - '0';
                }
                for (int i = 0; i < 4; i++) {
                    int newX = curr[0] + dx[i];
                    int newY = curr[1] + dy[i];
                    if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length && mat[newX][newY] != 'T' && !vis[newX][newY]) {
                        q.offer(new int[]{newX, newY});
                        vis[newX][newY] = true;
                    }
                }
            }
            dist++;

        }
    }
}
