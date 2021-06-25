import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/25 15:13
 * @since 1.0
 **/
public class Ac3485 {



    /**
     * 没用 tire 树超时
     *
     * @param args
     */
    public static void method1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] prefix = new int[n];
        int[] arr = new int[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            ans = Math.max(ans, arr[i]);
            prefix[i] = arr[i];
        }
        int size = n - 1;
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < size; i++) {
                prefix[i] ^= arr[i + j];
                ans = Math.max(ans, prefix[i]);
            }
            size--;
        }
        System.out.println(ans);
    }
}
