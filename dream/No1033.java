import java.util.Arrays;

/**
 * @ClassName MovingStonesUntilConsecutive
 * @Description #1033 移动石子直到连续
 * @Author MatthewHan
 * @Date 2020/7/2 17:16
 * @Version 1.0
 **/
public class No1033 {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int[] numMovesStonesPro(int a, int b, int c) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a > c) {
            int temp = a;
            a = c;
            c = temp;
        }
        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
        }
        int left = b - a;
        int right = c - b;


        int max = left + right - 2;
        int min = 0;
        if (left == 1 && right > 1 || left > 1 && right == 1) {
            min = 1;
        }
        if (left > 1 && right > 1) {
            if (left == 2 || right == 2) {
                min = 1;
            } else {
                min = 2;
            }
        }

        return new int[]{min, max};
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 72.16% 的用户
     * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int maxCount = Math.max(arr[2] - arr[0] - 2, 0);

        // 第一种
        if (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2]) {
            return new int[]{0, 0};
        }
        // 第二种
        if ((arr[0] + 1 == arr[1] && arr[1] + 1 != arr[2]) || (arr[0] + 1 != arr[1] && arr[1] + 1 == arr[2])) {
            return new int[]{1, maxCount};
        }

        // 第三种
        if ((arr[0] + 1 != arr[1] && arr[1] + 1 != arr[2])) {
            int minCount = 2;
            // 1,3,x 这种情况，x直接插到2
            if (arr[0] + 2 == arr[1] || arr[1] + 2 == arr[2]) {
                return new int[]{1, maxCount};
            } else {
                return new int[]{2, maxCount};
            }

        }

        return new int[]{-1, -1};


    }

    public static void main(String[] args) {

    }
}
