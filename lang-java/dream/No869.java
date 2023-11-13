import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/28 11:10
 * @since 1.0
 **/
public class No869 {

    static Set<String> x = new HashSet<>();

    static {
        int n = 1;
        while (n <= (int) 1e9) {
            x.add("" + n);
            n <<= 1;
        }
    }

    boolean ans;

    Set<String> gg;

    /**
     * 重新排序得到 2 的幂
     *
     * @param n
     * @return
     */
    public boolean reorderedPowerOf2(int n) {
        this.ans = false;
        this.gg = new HashSet<>();
        dfs(0, "" + n, "", new boolean[("" + n).length()]);
        return ans;

    }

    public void dfs(int size, String src, String str, boolean[] vis) {
        if (ans || gg.contains(str)) {
            return;
        }
        if (size >= src.length()) {
            if (str.charAt(0) != '0' && x.contains(str)) {
                ans = true;
            }
            return;
        }
        for (int i = 0; i < src.length(); i++) {
            if (!vis[i] || (!vis[i] && size == 0 && src.charAt(i) != '0')) {
                vis[i] = true;
                gg.add(str);
                dfs(size + 1, src, str + src.charAt(i), vis);
                vis[i] = false;
            }
        }
    }
}
