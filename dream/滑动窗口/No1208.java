package 滑动窗口;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/5 15:12
 **/
public class No1208 {

    int ans;
    int[] map;

    /**
     * #1208 尽可能使字符串相等
     * <p>
     * 执行用时： 1387 ms , 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 26.99% 的用户
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int[] map = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            map[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            int sum = 0;
            for (int j = i; j < s.length(); j++) {
                if (sum + map[j] > maxCost) {
                    ans = Math.max(ans, j - i);
                    break;
                }
                sum += map[j];
            }
            // 提前 break
            if (ans >= map.length - i) {
                return ans;
            }
        }
        return ans;
    }

    public void f(int maxCost, int start) {
        if (maxCost < 0) {
            return;
        }
        int c = 0;
        for (int i = start; i < map.length; i++) {
            if (maxCost >= map[i]) {
                maxCost -= map[i];
                c++;
            } else {
                break;
            }
            // 提前 break
            if (ans >= map.length - start) {
                return;
            }
        }
        ans = Math.max(ans, c);
    }

}
