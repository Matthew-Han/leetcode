package 深度优先搜索;

import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/6/19 8:54 下午
 * @since 1.0
 **/
public class No1239 {

    List<String> arr;
    int ans;

    /**
     * #1239 串联字符串的最大长度
     *
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        this.arr = arr;
        ans = 0;
        dfs(0, new int[26], 0);
        return ans;
    }

    public void dfs(int index, int[] cache, int cnt) {
        if (index >= arr.size()) {
            ans = Math.max(ans, cnt);
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            if (updateCache(cache, arr.get(i), true)) {
                dfs(i + 1, cache, arr.get(i).length() + cnt);
                // 回溯
                updateCache(cache, arr.get(i), false);
            } else {
                dfs(i + 1, cache, cnt);
            }
        }
    }

    public boolean updateCache(int[] cache, String curr, boolean flag) {
        if (flag) {
            // 判断自身是否符合条件
            boolean[] tmp = new boolean[26];
            for (int i = 0; i < curr.length(); i++) {
                if (tmp[curr.charAt(i) - 'a']) {
                    return false;
                }
                tmp[curr.charAt(i) - 'a'] = true;
            }
            // 判断相加的字符串是否符合条件
            for (int i = 0; i < curr.length(); i++) {
                if (cache[curr.charAt(i) - 'a'] > 0) {
                    return false;
                }
            }
            for (int i = 0; i < curr.length(); i++) {
                cache[curr.charAt(i) - 'a']++;
            }
        } else {
            for (int i = 0; i < curr.length(); i++) {
                cache[curr.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
