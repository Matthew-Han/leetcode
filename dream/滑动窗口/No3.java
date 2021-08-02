package 滑动窗口;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:49
 * @since 1.0
 **/
public class No3 {

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int prev = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int tar = fuck(arr, prev, i, arr[i]);
            if (tar >= 0) {
                prev = tar + 1;
            }
            ans = Math.max(ans, i - prev + 1);
        }
        return ans;
    }

    public int fuck(char[] arr, int fromIndex, int toIndex, char key) {
        for (int i = fromIndex; i < toIndex; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
