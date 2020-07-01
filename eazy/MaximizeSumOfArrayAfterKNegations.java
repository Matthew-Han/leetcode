import java.util.Arrays;

/**
 * @ClassName MaximizeSumOfArrayAfterKNegations
 * @Description #1005 K 次取反后最大化的数组和
 * @Author MatthewHan
 * @Date 2020/7/1 11:03
 * @Version 1.0
 **/
public class MaximizeSumOfArrayAfterKNegations {

    /**
     * 一次排序；
     * 下标从0开始比较左右最近的的元素大小，三者出现更小的数字，指针移到相应位置，该元素替换成相反数；
     * 继续比较左右最近的元素；
     * 注意下标为头尾的特殊情况。
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 86.51% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    public static int largestSumAfterKNegationsPro(int[] arr, int k) {
        Arrays.sort(arr);
        int minIndex = 0;
        while (k > 0) {
            System.out.println("arr = " + Arrays.toString(arr));
            int left = minIndex - 1;
            int right = minIndex + 1;
            // 当最小值在首位
            if (minIndex == 0) {
                if (right < arr.length && arr[right] < arr[minIndex]) {
                    arr[right] = -arr[right];
                    minIndex = right;
                } else {
                    arr[minIndex] = -arr[minIndex];
                }
                // 最小值在末尾
            } else if (minIndex == arr.length - 1) {
                if (left >= 0 && arr[left] < arr[minIndex]) {
                    arr[left] = -arr[left];
                    minIndex = left;
                } else {
                    arr[minIndex] = -arr[minIndex];
                }
                // 最小值在数组中间，和左右两个元素比较大小
            } else {
                if (left >= 0 && right < arr.length && arr[left] < arr[minIndex] && arr[left] < arr[right]) {
                    arr[left] = -arr[left];
                    minIndex = left;
                }
                if (left >= 0 && right < arr.length && arr[right] < arr[minIndex] && arr[right] < arr[left]) {
                    arr[right] = -arr[right];
                    minIndex = right;
                } else {
                    arr[minIndex] = -arr[minIndex];
                }
            }
            k--;

        }
        System.out.println("arr = " + Arrays.toString(arr));
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }


    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 28.84% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    public static int largestSumAfterKNegations(int[] arr, int k) {
        int sum = 0;
        while (k > 0) {
            sum = findMin(arr);
            k--;
        }
        return sum;
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min >= arr[i]) {
                min = arr[i];
                index = i;
            }
            sum += arr[i];
        }
        sum -= arr[index] * 2;
        arr[index] = -arr[index];
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegationsPro(new int[]{-4, 4, -3, 3, -4, -1, 8, -7, -7}, 3));
    }
}
