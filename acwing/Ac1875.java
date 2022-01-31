import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/27 11:26 27
 * @since 1.0
 **/
public class Ac1875 {

    /**
     * 贝茜的报复
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        Map<String, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] t = sc.readLine().split(" ");
            cache.put(t[0], cache.getOrDefault(t[0], new ArrayList<>()));
            cache.get(t[0]).add(Integer.parseInt(t[1]));
        }
        int ans = 0;
        int even0 = 0;
        for (int m : cache.get("M")) {
            even0 += (m & 1) == 0 ? 1 : 0;
        }
        ans += even0 * cache.get("B").size() * cache.get("E").size() * cache.get("S").size() * cache.get("I").size() * cache.get("G").size() * cache.get("O").size();
        int even1 = 0;
        for (int b : cache.get("B")) {
            for (int i : cache.get("I")) {
                even1 += ((b + i) & 1) == 0 ? 1 : 0;
            }
        }
        ans += (cache.get("M").size() - even0) * even1 * cache.get("E").size() * cache.get("S").size() * cache.get("G").size() * cache.get("O").size();
        int even2 = 0;
        for (int g : cache.get("G")) {
            for (int o : cache.get("O")) {
                for (int e : cache.get("E")) {
                    for (int s : cache.get("S")) {
                        even2 += ((g + o + e + s) & 1) == 0 ? 1 : 0;
                    }
                }
            }
        }
        ans += (cache.get("M").size() - even0) * (cache.get("B").size() * cache.get("I").size() - even1) * even2;
        System.out.println(ans);
    }
}
