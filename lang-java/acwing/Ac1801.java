import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/1 15:03 01
 * @since 1.0
 **/
public class Ac1801 {


    /**
     * 蹄子剪刀布
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String k = sc.readLine();
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        Set<String> set0 = new HashSet<String>() {{
            add("1 2");
            add("2 3");
            add("3 1");
        }};
        Set<String> set1 = new HashSet<String>() {{
            add("1 3");
            add("3 2");
            add("2 1");
        }};
        int t0 = 0;
        int t1 = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (set0.contains(e.getKey())) {
                t0 += e.getValue();
            }
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (set1.contains(e.getKey())) {
                t1 += e.getValue();
            }
        }
        System.out.println(Math.max(t0, t1));
    }

}
