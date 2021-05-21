package 滑动窗口;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/20 16:09
 **/
public class No1031 {

    /**
     * #1031 两个非重叠子数组的最大和
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 39.60% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 70.47% 的用户
     *
     * @param a
     * @param l
     * @param m
     * @return
     */
    public int maxSumTwoNoOverlap(int[] a, int l, int m) {
        int ans = func(a, l, m);

        int temp = l;
        l = m;
        m = temp;

        ans = Math.max(ans, func(a, l, m));

        return ans;
    }

    public int func(int[] a, int l, int m) {
        int limit = a.length - m;

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < l; i++) {
            leftSum += a[i];
        }
        int tmp = leftSum;
        for (int i = a.length - 1; i >= limit; i--) {
            rightSum += a[i];
        }
        int max = 0;
        while (limit >= l) {
            int offset = 0;
            leftSum = tmp;
            while (offset + l <= limit) {
                // System.out.println("l: " + leftSum);
                // System.out.println("r: " + rightSum);
                max = Math.max(max, leftSum + rightSum);
                leftSum -= a[offset];
                leftSum += a[offset + l];
                offset++;
            }
            limit--;
            rightSum += a[limit];
            rightSum -= a[limit + m];
            // System.out.println("-------");
        }
        return max;
    }
}
