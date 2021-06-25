import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/25 14:32
 * @since 1.0
 **/
public class Ac3493 {


    /**
     * 最大的和
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int[] choose = new int[n];
        for (int i = 0; i < n; i++) {
            choose[i] = sc.nextInt();
            sum += choose[i] == 1 ? arr[i] : 0;
        }
        for (int i = 0; i <= k - 1; i++) {
            sum += choose[i] == 0 ? arr[i] : 0;
        }

        long ans = sum;
        for (int i = 1, j = i + k - 1; j < n; i++, j++) {
            sum += choose[j] == 0 ? arr[j] : 0;
            sum -= choose[i - 1] == 0 ? arr[i - 1] : 0;
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

}
