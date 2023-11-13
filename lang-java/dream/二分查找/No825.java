package 二分查找;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/27 15:18
 * @since 1.0
 **/
public class No825 {

    /**
     * 适龄的朋友
     *
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        int ans = 0;
        Arrays.sort(ages);
        for (int i = ages.length - 1; i >= 0; i--) {
            int l = 0;
            int r = i;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (fuck(ages[i], ages[mid])) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            // 处理相同的
            for (int j = i + 1; j < ages.length; j++) {
                if (ages[j] == ages[i] && fuck(ages[i], ages[j])) {
                    ans++;
                } else {
                    break;
                }
            }
            // System.out.println(l);
            ans += i - l;
        }
        return ans;
    }

    public boolean fuck(int x, int y) {
        return y > 0.5 * x + 7 && !(y > 100 && x < 100);
    }
}
