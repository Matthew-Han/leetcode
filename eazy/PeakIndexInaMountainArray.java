/**
 * @ClassName PeakIndexInaMountainArray
 * @Description #852 山脉数组的峰顶索引
 * @Author MatthewHan
 * @Date 2020/6/20 19:36
 * @Version 1.0
 **/
public class PeakIndexInaMountainArray {

    /**
     * 因为数组a一定是呈现（只有）一个山峰的序列，所以判断next元素小于或等于即可当前元素即可
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param a
     * @return
     */
    public static int peakIndexInMountainArrayPro(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i + 1 < a.length && a[i + 1] <= a[i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 26.22% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param a
     * @return
     */
    public static int peakIndexInMountainArray(int[] a) {
        int index = -1;
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                index = i;
            }

        }
        return index;
    }

    public static void main(String[] args) {

    }
}
