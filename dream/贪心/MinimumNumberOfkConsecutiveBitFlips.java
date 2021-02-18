package 贪心;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/18 13:55
 **/
public class MinimumNumberOfkConsecutiveBitFlips {

    /**
     * #995 k 连续位的最小翻转次数
     * 执行用时： 2372 ms , 在所有 Java 提交中击败了 23.60% 的用户
     * 内存消耗： 46.2 MB , 在所有 Java 提交中击败了 88.13% 的用户
     *
     * @param a
     * @param k
     * @return
     */
    public int minkBitFlips(int[] a, int k) {
        int ans = 0;
        for (int i = 0; i < a.length - k + 1; i++) {
            if (a[i] == 0) {
                ans++;
                a[i] = 1;
                for (int j = i + 1; j < i + k; j++) {
                    a[j] = 1 - a[j];
                }
            }
        }
        for (int i = a.length - k + 1; i < a.length; i++) {
            if (a[i] == 0) {
                return -1;
            }
        }
        return ans;

    }
}
