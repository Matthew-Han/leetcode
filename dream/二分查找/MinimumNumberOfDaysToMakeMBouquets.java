package 二分查找;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @date 2021/5/10 10:01
 * @description
 * @since 1.0.0
 **/
public class MinimumNumberOfDaysToMakeMBouquets {

    /**
     * #1482 制作 m 束花所需的最少天数
     *
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int[] arr = bloomDay.clone();
        Arrays.sort(arr);
        int left = 0;
        int right = bloomDay.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (check(bloomDay, arr[mid], m, k)) {
                right = mid - 1;
                ans = arr[mid];
            } else {
                left = mid + 1;

            }
        }
        return ans;
    }

    public boolean check(int[] bloomDay, int mid, int m, int k) {
        boolean[] vis = draw(bloomDay, mid);
        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) {
                boolean flag = true;
                // j = i 而不是 j = i + 1 保证一定会进入一次循环
                for (int j = i; j < i + k; j++) {
                    // 数组下标越界 或 中间不连续 则跳出本次循环
                    if (j >= vis.length || !vis[j]) {
                        flag = false;
                        i = j - 1;
                        break;
                    }
                }
                if (flag) {
                    m--;
                    i += k - 1;
                }
            }
            if (m <= 0) {
                return true;
            }
        }
        return m <= 0;

    }

    public boolean[] draw(int[] bloomDay, int mid) {
        boolean[] vis = new boolean[bloomDay.length];
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                vis[i] = true;
            }
        }
        return vis;
    }
}
