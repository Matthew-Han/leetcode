import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:41
 * @description
 * @since 1.0.0
 **/
public class Ac3664 {

    /**
     * 数组补全
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int sum = 0;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        boolean flag = true;
        // 最左边的 index
        int index = 0;
        // 重复的数字的最大 index
        int maxIndex = 0;
        int prev = -1;
        for (int i = 0; i < k; i++) {
            if (flag && arr[i] >= y) {
                index = i;
                flag = false;
                prev = arr[i];
                continue;
            }
            if (!flag && prev == arr[i]) {
                maxIndex = i;
            }
        }


        // 未出现满足中位数的数字
        if (flag) {
            if (n - k <= n / 2) {
                System.out.print(-1);
                return;
            }
            // 先补上 k + 1 个的已有元素使得当前数组的中位数是目标值
            sum += (k + 1) * y;
            // 两边对称补齐
            sum += (n - 2 * k - 1) / 2;
            sum += (n - 2 * k - 1) / 2 * y;
            if (sum <= x) {
                for (int i = 0; i < (n - 2 * k - 1) / 2; i++) {
                    System.out.print(1);
                    System.out.print(" ");

                }
                for (int i = 0; i < (n - 2 * k - 1) / 2; i++) {
                    System.out.print(y);
                    System.out.print(" ");

                }
                for (int i = 0; i < k + 1; i++) {
                    System.out.print(y);
                    if (i <= k) {
                        System.out.print(" ");
                    }
                }
            } else {
                System.out.println(-1);
            }
        } else {
            int left = index;
            int right = k - left - 1;
            int curr = n - k;
            int leftNum = 0;
            int rightNum = 0;
            while (curr-- > 0) {
                // 如果有满足中位数的元素
                // 可以先满足 maxIndex / 2 个 1
                if (index < maxIndex / 2) {
                    sum++;
                    leftNum++;
                    index++;
                    continue;
                }
                // 然后就是对称的两边补齐
                if (left <= right) {
                    sum++;
                    left++;
                    leftNum++;
                    continue;
                }
                sum += y;
                right++;
                rightNum++;
            }

            if (sum > x) {
                System.out.println(-1);
            } else {
                while (leftNum-- > 0) {
                    System.out.print(1);
                    System.out.print(" ");
                }
                while (rightNum-- > 0) {
                    System.out.print(y);
                    if (rightNum != 0) {
                        System.out.print(" ");
                    }
                }
            }

        }

    }
}
