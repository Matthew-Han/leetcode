package 第234场周赛;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/29 09:05
 **/
public class MinimumNumberOfOperationsToReinitializeaPermutation {

    /**
     * #1806 还原排列的最少操作步数
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public int reinitializePermutation(int n) {
        int[] ex = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = i;
        }
        // test1
        for (int i = 0; i < n; i++) {
            if ((i % 2) == 0) {
                ex[i] = i / 2;
            } else {
                ex[i] = n / 2 + (i - 1) / 2;
            }
        }
        int ans = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                t[i] = ex[t[i]];
            }
            ans++;
            if (t[1] == 1) {
                return ans;
            }
        }
    }
}
