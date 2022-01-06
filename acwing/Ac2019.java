import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/5 11:19
 * @since 1.0
 **/
public class Ac2019 {

    static Set<String> hay;

    static int[][] dxy = {{0, 0, -1, 1}, {-1, 1, 0, 0}};

    static int[][] mem;


    /**
     * 拖拉机
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        hay = new HashSet<>();
        mem = new int[1010][1010];
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] a = sc.readLine().split(" ");
        int n = Integer.parseInt(a[0]);
        int x = Integer.parseInt(a[1]);
        int y = Integer.parseInt(a[2]);
        for (int[] m : mem) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            hay.add(sc.readLine());
        }
        System.out.println(bfs(new int[]{x, y}));

    }

    public static int bfs(int[] target) {
        // 2: 当前干艹数
        // 3: 当前距离
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int limit = pq.size();
            for (int i = 0; i < limit; i++) {
                int[] curr = pq.poll();
                if (target[0] == curr[0] && target[1] == curr[1]) {
                    return curr[2];
                }
                for (int j = 0; j < 4; j++) {
                    int newX = curr[0] + dxy[0][j];
                    int newY = curr[1] + dxy[1][j];
                    if (newX >= 0 && newY >= 0 && newX < 1010 && newY < 1010) {
                        int cnt = hay.contains(newX + " " + newY) ? curr[2] + 1 : curr[2];
                        if (cnt < mem[newX][newY]) {
                            mem[newX][newY] = cnt;
                            pq.offer(new int[]{newX, newY, cnt});
                        }

                    }
                }
            }

        }
        return Integer.MAX_VALUE;
    }

}
