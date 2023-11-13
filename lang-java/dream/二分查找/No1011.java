package 二分查找;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/26 14:18
 * @since 1.0.0
 **/
public class No1011 {

    /**
     * #1011 在 D 天内送达包裹的能力
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 45.71% 的用户
     * 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 76.54% 的用户
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int ans = Integer.MAX_VALUE;
        int max = 0;
        int min = Integer.MIN_VALUE;
        for (int w : weights) {
            max += w;
            min = Math.max(min, w);
        }
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println(mid);
            if (check(weights, mid, D)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public boolean check(int[] weights, int load, int D) {
        int tmp = load;
        for (int w : weights) {
            if (tmp < w) {
                if (D > 1) {
                    D--;
                    tmp = load;
                    tmp -= w;
                } else {
                    return false;
                }
            } else {
                tmp -= w;
            }
        }
        return true;
    }

}
