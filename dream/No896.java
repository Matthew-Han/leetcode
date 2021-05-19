import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MonotonicArray
 * @Description #896 单调数列
 * @Author MatthewHan
 * @Date 2020/6/22 17:27
 * @Version 1.0
 **/
public class No896 {

    /**
     * 某个范例，带秀啊
     * 统计个数就vans了
     *
     * @param arr
     * @return
     */
    public boolean daiXiu(int[] arr) {
        int asc = 0, dsc = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                asc++;
            }
            if (arr[i] >= arr[i + 1]) {
                dsc++;
            }
        }
        return asc == arr.length - 1 || dsc == arr.length - 1;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 47.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static boolean isMonotonicPro(int[] arr) {
        if (arr.length < 3) {
            return true;
        }
        boolean isFirst = true;
        int prevEle = arr[0];
        boolean check = false;
        for (int a : arr) {
            if (a != prevEle) {
                if (isFirst) {
                    check = a - prevEle > 0;
                    isFirst = false;
                }
                if (check != a - prevEle > 0) {
                    return false;
                }
            }
            prevEle = a;
        }
        return true;
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
        System.out.println(isMonotonicPro(new int[]{6, 5, 2, 1}));
        System.out.println(isMonotonicPro(new int[]{3, 5, 2, 1}));
        System.out.println(isMonotonicPro(new int[]{5, 5, 2, 1}));
        System.out.println(isMonotonicPro(new int[]{5, 5, 6, 6}));
    }
}
