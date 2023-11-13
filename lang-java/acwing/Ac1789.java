import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/31 17:34 31
 * @since 1.0
 **/
public class Ac1789 {


    /**
     * 牛为什么过马路 II
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = sc.readLine().toCharArray();
        Map<Character, Set<Character>> map = new HashMap<>();
        boolean[][] vis = new boolean[26][26];
        char start = 'A';
        for (int i = 0; i < 26; i++) {
            boolean flag = false;
            map.put(start, map.getOrDefault(start, new HashSet<>()));
            for (int j = 0; j < 52; j++) {
                if (!flag && arr[j] == start) {
                    flag = true;
                    continue;
                }
                if (flag && arr[j] == start) {
                    break;
                }
                if (flag) {
                    map.get(start).add(arr[j]);
                }
            }
            start++;
        }
        start = 'A';
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            Set<Character> set = map.getOrDefault(start, new HashSet<>());
            for (Character v : set) {
                if (map.get(v).contains(start) && !vis[start - 'A'][v - 'A'] && !vis[v - 'A'][start - 'A']) {
                    ans++;
                    vis[start - 'A'][v - 'A'] = true;
                    vis[v - 'A'][start - 'A'] = true;
                }
            }
            start++;
        }
        System.out.println(ans);
    }

}
