package 动态规划;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/8 11:15
 **/
public class No978 {

    /**
     * #978 最长湍流子数组
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 97.24% 的用户
     * 内存消耗： 42 MB , 在所有 Java 提交中击败了 44.45% 的用户
     *
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        if (arr.length == 2) {
            return arr[0] == arr[1] ? 1 : 2;
        }
        int prev = arr[1] - arr[0];
        int ans = 0;
        int tmp = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            int curr = arr[i + 1] - arr[i];
            if (prev == 0) {
                ans = Math.max(ans, curr == 0 ? tmp : tmp + 1);
                tmp = 1;
                prev = curr;
                continue;
            }
            if (prev > 0 && curr < 0) {
                tmp++;
            } else if (prev < 0 && curr > 0) {
                tmp++;
            } else {
                ans = Math.max(ans, tmp + 1);
                tmp = 1;
            }
            if (i == arr.length - 2) {
                ans = Math.max(ans, tmp + 1);
            }
            prev = curr;
        }
        return ans;
    }

}
