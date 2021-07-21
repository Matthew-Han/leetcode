import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/21 09:29
 * @since 1.0
 **/
public class Ac3774 {

    /**
     * 亮灯时长
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[k + 2];
            for (int i = 1; i <= k; i++) {
                arr[i] = sc.nextInt();
            }
            arr[0] = 0;
            arr[k + 1] = m;
            // System.out.println(Arrays.toString(arr));
            int[] fuck = new int[k + 1];
            if ((k & 1) == 1) {
                fuck[k] = arr[k + 1] - arr[k];
            }
            int prev = fuck[k];
            for (int i = k; i > 0; i--) {
                if (i % 2 == 0) {
                    fuck[i] = prev + arr[i] - arr[i - 1];
                    prev = fuck[i];
                } else {
                    fuck[i] = prev;
                }
            }

            // System.out.println(Arrays.toString(fuck));
            int max = 0;
            for (int i = 1; i < k + 2; i++) {
                if (i % 2 != 0) {
                    max += arr[i] - arr[i - 1];
                }
            }
            int tmp = 0;
            for (int i = 1; i < k + 1; i += 2) {
                tmp += arr[i] - arr[i - 1];
                max = Math.max(max, tmp + fuck[i] - 1);
            }
            System.out.println(max);
        }
    }
}
