package 排列组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/22 10:18
 * @since 1.0
 **/
public class L38 {

    List<String> list;
    Map<String, Boolean> cache;

    /**
     * 剑指 Offer #38 字符串的排列
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        list = new ArrayList<>();
        cache = new HashMap<>();
        dfs(s, new boolean[s.length()], 0, new StringBuilder());
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }

    public void dfs(String s, boolean[] vis, int size, StringBuilder sb) {
        if (size == s.length() && !cache.containsKey(sb.toString())) {
            list.add(sb.toString());
            cache.put(sb.toString(), true);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                sb.append(s.charAt(i));
                dfs(s, vis, size + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                vis[i] = false;
            }
            i %= s.length();
        }
    }
}
