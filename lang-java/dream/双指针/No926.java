package 双指针;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/16 17:21 16
 * @since 1.0
 **/
public class No926 {


    /**
     * 将字符串翻转到单调递增
     *
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        int t = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            t += c == '1' ? 1 : 0;
        }
        int ans = t;
        for (int i = arr.length - 1; i >= 0; i--) {
            t += arr[i] == '0' ? 1 : -1;
            ans = Math.min(ans, t);
        }
        return ans;
    }
}
