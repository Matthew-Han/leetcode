package 双指针;

/**
 * @ClassName 双指针.SquaresOfaSortedArray
 * @Description #977 有序数组的平方
 * @Author MatthewHan
 * @Date 2020/6/30 09:51
 * @Version 1.0
 **/
public class SquaresOfaSortedArray {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param arr
     * @return
     */
    public int[] sortedSquares(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int[] result = new int[arr.length];
        for (int n = arr.length - 1; n >= 0; n--) {
            if (i > j) {
                return result;
            }
            if (arr[i] * arr[i] >= arr[j] * arr[j]) {
                result[n] = arr[i] * arr[i];
                i++;
            } else {
                result[n] = arr[j] * arr[j];
                j--;
            }

        }
        return result;
    }
}
