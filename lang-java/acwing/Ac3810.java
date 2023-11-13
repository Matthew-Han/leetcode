import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:47
 * @since 1.0
 **/
public class Ac3810 {

    /**
     * 最长连续休息时间
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k * 2];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            System.arraycopy(arr, 0, arr, k, k);
            int a = 0;
            int t = 0;
            for (int i = 0; i < 2 * k; i++) {
                if (arr[i] == 1) {
                    t++;
                } else {
                    a = Math.max(a, t);
                    t = 0;
                }
            }
            System.out.println(a);
        }
    }
}
