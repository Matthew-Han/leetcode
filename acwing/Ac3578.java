import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:40
 * @description
 * @since 1.0.0
 **/
public class Ac3578 {

    /**
     * 最大中位数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int index = n / 2;
        if (arr.length == 1) {
            System.out.println(arr[0] + k);
            return;
        }
        int curr = arr[index];
        for (int i = index + 1; i < n; i++) {

            int diff = arr[i] - curr;
            if (k >= (i - index) * diff) {
                k -= (i - index) * diff;
                curr = arr[i];

            } else {
                int part = k / (i - index);
                System.out.println(curr + part);
                return;
            }
            if (i == n - 1) {
                int part = k / (i - index + 1);
                System.out.println(curr + part);
                return;
            }
        }
        System.out.println(curr);
    }
}
