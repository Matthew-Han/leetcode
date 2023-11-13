package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/26 14:50 26
 * @since 1.0
 **/
public class No467 {

    /**
     * 环绕字符串中唯一的子字符串
     * <p>
     * 就是将每个开头字母能连接的最长串（最大值），26 个字母都加起来就行了。
     *
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int ans = 0;
        int[] vis = new int[26];
        char[] array = p.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int cnt = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j - 1] == array[j] - 1 || array[j - 1] == array[j - 1] + 25) {
                    cnt++;
                } else {
                    break;
                }
            }
            vis[array[i] - 'a'] = Math.max(vis[array[i] - 'a'], cnt);
        }
        for (int i = 0; i < 26; i++) {
            ans += vis[i];
        }
        return ans;
    }
}
