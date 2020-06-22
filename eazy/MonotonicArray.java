import java.util.Arrays;

/**
 * @ClassName MonotonicArray
 * @Description #896 单调数列
 * @Author MatthewHan
 * @Date 2020/6/22 17:27
 * @Version 1.0
 **/
public class MonotonicArray {

    /**
     *
     * @param arr
     * @return
     */
    public static boolean isMonotonicPro(int[] arr) {

        return false;
    }
    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 8.75% 的用户
     * 内存消耗： 47.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static boolean isMonotonic(int[] arr) {

        int[] tempArr = arr.clone();
        Arrays.sort(arr);
        if (Arrays.equals(arr, tempArr)) {
            return true;
        }
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return Arrays.equals(tempArr, arr);


    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{6, 5, 2, 1}));
    }
}
