/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/16 10:16
 * @since 1.0
 **/
public class No696 {

    /**
     * 计数二进制子串
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        char[] arr = s.toCharArray();
        int prev = arr[0];
        int sum1 = 1;
        int sum2 = 0;
        boolean flag = false;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (!flag && arr[i] == prev) {
                sum1++;
            } else if (!flag && arr[i] != prev) {
                flag = true;
                prev = arr[i];
                sum2++;
            } else if (flag && arr[i] == prev) {
                sum2++;
            } else if (flag && arr[i] != prev) {
                ans += Math.min(sum1, sum2);
                sum1 = sum2;
                sum2 = 1;
                prev = arr[i];
            }
        }
        ans += Math.min(sum1, sum2);
        return ans;

    }
}
