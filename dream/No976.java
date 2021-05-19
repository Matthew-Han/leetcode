import java.util.Arrays;

/**
 * @ClassName LargestPerimeterTriangle
 * @Description #976 三角形的最大周长
 * @Author MatthewHan
 * @Date 2020/6/30 09:47
 * @Version 1.0
 **/
public class No976 {

    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 88.56% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param arr
     * @return
     */
    public static int largestPerimeter(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 2; i--) {
            int second = arr[i - 1];
            int third = arr[i - 2];
            if (second + third > arr[i]) {
                return second + third + arr[i];
            }
        }
        return 0;
    }


}
