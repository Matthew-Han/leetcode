/**
 * @ClassName PeakIndexInaMountainArray
 * @Description #852 山脉数组的峰顶索引
 * @Author MatthewHan
 * @Date 2020/6/20 19:36
 * @Version 1.0
 **/
public class No852 {

    /**
     * @param arr
     * @return
     * @date 2021/06/16
     */
    public int peakIndexInMountainArrayNew(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (mid - 1 >= 0 && mid + 1 < arr.length
                    && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid - 1 >= 0 && mid + 1 < arr.length
                    && arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                l = mid;
            } else if (mid - 1 >= 0 && mid + 1 < arr.length
                    && arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                r = mid;
            }
        }
        return l;
    }

    /**
     * 因为数组 a 一定是呈现（只有）一个山峰的序列，所以判断 next 元素小于或等于即可当前元素即可
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
