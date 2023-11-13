package 第245场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 15:21
 * @description
 * @since 1.0.0
 **/
public class No1898 {
    /**
     * #1898 可移除字符的最大数目
     *
     * @param s
     * @param p
     * @param removable
     * @return
     */
    public int maximumRemovals(String s, String p, int[] removable) {
        if (!isSubsequence(s, p, removable, 0)) {
            return 0;
        }
        int l = 0;
        int r = removable.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            //System.out.println(Arrays.toString(c));
            if (isSubsequence(s, p, removable, mid)) {
                if (mid + 1 < removable.length) {
                    if (!isSubsequence(s, p, removable, mid + 1)) {
                        return mid + 1;
                    } else {
                        l = mid + 1;
                        continue;
                    }
                }
                l = mid;

            } else {
                r = mid - 1;
            }
        }
        return l + 1;

    }

    public boolean isSubsequence(String s, String t, int[] removable, int mid) {
        boolean[] bucket = new boolean[100001];
        for (int i = 0; i <= mid; i++) {
            bucket[removable[i]] = true;
        }
        int ans = 0;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            for (int j = index; j < s.length(); j++) {
                if (!bucket[j] && t.charAt(i) == s.charAt(j)) {
                    ans++;
                    index = j + 1;
                    break;
                }
            }
        }
        return ans == t.length();
    }

}
