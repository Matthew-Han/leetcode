package 深度优先搜索;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Matthew Han
 * @date 2021/5/7 12:25
 * @description
 * @since 1.0.0
 **/
public class No1079 {

    Set<String> ans;
    String p;

    /**
     * #1079 活字印刷
     *
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 1) {
            return 1;
        }
        p = tiles;
        ans = new HashSet<>();
        for (int i = 1; i <= tiles.length(); i++) {
            dfs(new StringBuilder(), i, new boolean[tiles.length()]);
        }
        return ans.size();
    }

    public void dfs(StringBuilder tmp, int size, boolean[] vis) {
        if (tmp.length() == size) {
            ans.add(tmp.toString());
            return;
        }
        for (int j = 0; j < p.length(); j++) {
            if (!vis[j]) {
                tmp.append(p.charAt(j));
                vis[j] = true;
                dfs(tmp, size, vis);
                tmp.deleteCharAt(tmp.length() - 1);
                vis[j] = false;
            }
            j %= p.length();

        }

    }
}
