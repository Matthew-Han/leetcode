import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/20 16:27 20
 * @since 1.0
 **/
public class Ac1922 {

    /**
     * 懒惰的牛
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);

        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] t = sc.readLine().split(" ");
            int key = Integer.parseInt(t[1]);
            int val = Integer.parseInt(t[0]);
            map.put(key, val);
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        int k = Math.min(2 * Integer.parseInt(nk[1]) + 1, max - min + 1);
        long cnt = 0;
        for (int i = min; i < min + k; i++) {
            if (map.containsKey(i)) {
                cnt += map.get(i);
            }
        }
        int limit = max - min + 1;
        long ans = cnt;
        for (int i = min + 1; i <= limit - k; i++) {
            if (map.containsKey(i - 1)) {
                cnt -= map.get(i - 1);
            }
            cnt += map.getOrDefault(i + k, 0);
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
