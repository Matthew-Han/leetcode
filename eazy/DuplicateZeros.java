import java.util.Arrays;

/**
 * @ClassName DuplicateZeros
 * @Description #1089 复写零
 * @Author MatthewHan
 * @Date 2020/7/6 09:42
 * @Version 1.0
 **/
public class DuplicateZeros {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param arr
     */
    public static void duplicateZerosPro(int[] arr) {
        int[] temp = new int[arr.length];
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            temp[j] = arr[i];
            if (arr[i] == 0) {
                temp[j++] = 0;
            }
            i++;
            j++;
        }

        System.arraycopy(temp, 0, arr, 0, temp.length);
        System.out.println("arr = " + Arrays.toString(arr));
    }


    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 38.26% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param arr
     */
    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }

        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        duplicateZerosPro(new int[]{0, 1, 0, 2, 3, 0, 4, 5, 0});
    }
}
