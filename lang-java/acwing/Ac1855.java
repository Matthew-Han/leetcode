import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/1 16:28 01
 * @since 1.0
 **/
public class Ac1855 {

    /**
     * 愤怒的奶牛
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(sc.readLine()));
        }
        int ans = 0;
        for (int i : set) {
            ans = Math.max(ans, bfs(set, i));
        }
        System.out.println(ans);

    }

    public static int bfs(TreeSet<Integer> set, int start) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.offer(start);
        vis.add(start);
        int ans = 0;
        int radius = 1;
        while (!q.isEmpty()) {
            int limit = q.size();
            for (int i = 0; i < limit; i++) {
                int curr = q.poll();
                ans++;
                for (int x = 1; x <= radius; x++) {
                    if (!vis.contains(curr - x) && set.contains(curr - x)) {
                        vis.add(curr - x);
                        q.offer(curr - x);
                    }
                    if (!vis.contains(curr + x) && set.contains(curr + x)) {
                        vis.add(curr + x);
                        q.offer(curr + x);
                    }
                }
            }
            radius++;
        }
        return ans;
    }

}
