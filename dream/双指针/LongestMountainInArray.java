package 双指针;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @date 2020/10/26 02:41
 **/
public class LongestMountainInArray {

    /**
     * #845 数组中的最长山脉
     *
     * @param arr
     * @return
     */
    public int longestMountain(int[] arr) {
        int max = 0;
        int len = 0;
        int i = 0;
        // 是否进入山脉判断
        boolean rising = true;
        while (i < arr.length) {
            len++;
            if (rising) {
                if (i - 1 >= 0 && i + 1 < arr.length && arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    rising = false;
                    i++;
                    continue;
                } else if (i + 1 < arr.length && arr[i] >= arr[i + 1]) {
                    len = 0;
                }
            } else {
                if (i + 1 < arr.length && arr[i] <= arr[i + 1]) {
                    max = Math.max(max, len);
                    rising = true;
                    // 连续的两个山脉会共享一个元素
                    if (arr[i] == arr[i + 1]) {
                        len = 0;
                    } else {
                        len = 1;
                    }
                }
                // 末尾边界判断
                if (i == arr.length - 1) {
                    max = Math.max(max, len);
                }
            }
            i++;
        }
        return max;
    }
}
