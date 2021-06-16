package 双指针;

/**
 * @ClassName MaxConsecutiveOnesIII
 * @Description #1004 最大连续1的个数 III
 * @Author MatthewHan
 * @Date 2020/8/10 15:24
 * @Version 1.0
 **/
public class No1004 {

    /**
     * 超时，和 {@link No1248 } 统计「优美子数组」并称超时 2 兄弟。。
     *
     * @param arr
     * @param k
     * @return
     */
    public int longestOnes(int[] arr, int k) {
        int len = arr.length;
        for (int j = len; j > 0; j--) {
            int i = 0;
            while (i + j <= len) {
                if (count0(arr, i, i + j) <= k) {
                    return j;
                }
                i++;
            }
        }
        return 0;
    }

    public static int count0(int[] arr, int left, int right) {
        int count0 = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                count0++;
            }
        }
        return count0;
    }

}
