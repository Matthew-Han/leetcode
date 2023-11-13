import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/6 16:00
 * @since 1.0
 **/
public class Ac2014 {

    /**
     * 岛
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Integer::compare);
        int prev = -1;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(sc.readLine());
            if (curr != prev) {
                map.put(curr, map.getOrDefault(curr, new ArrayList<>()));
                map.get(curr).add(idx);
                idx++;
            }
            prev = curr;
        }
        boolean[] vis = new boolean[idx];
        int ans = 0;
        int t = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indexs = entry.getValue();
            for (Integer index : indexs) {
                vis[index] = true;
                if (index - 1 >= 0 && !vis[index - 1] && index + 1 < idx && !vis[index + 1]) {
                    t++;
                }
                if (index - 1 >= 0 && vis[index - 1] && index + 1 < idx && vis[index + 1]) {
                    t--;
                }
                if (index == 0 && vis[index + 1]) {
                    t--;
                }
                if (index == idx - 1 && vis[index - 1]) {
                    t--;
                }
            }
            ans = Math.max(ans, t);
        }
        System.out.println(ans);

    }
}
