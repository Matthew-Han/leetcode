package 双指针;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/2 09:08
 **/
public class M1721 {

    int[] tmp;

    /**
     * 面试题 17.21. 直方图的水量
     * 执行用时： 1074 ms , 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 92.09% 的用户
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        this.tmp = height;
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        for (int k : height) {
            max = Math.max(max, k);
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int[] curr = func(left, right, i);
            // 提前终止条件
            if (curr[0] == -1) {
                return ans;
            }

            for (int j = curr[0]; j <= curr[1]; j++) {
                if (height[j] < i) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int[] func(int left, int right, int t) {
        int[] res = new int[2];
        for (int i = left; i < tmp.length; i++) {
            if (tmp[i] >= t) {
                res[0] = i;
                break;
            }
        }
        for (int j = right; j >= 0; j--) {
            if (tmp[j] >= t) {
                res[1] = j;
                break;
            }
        }
        if (res[0] < res[1]) {
            return res;
        }
        return new int[]{-1, -1};
    }
}
