import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/27 11:23
 * @since 1.0
 **/
public class Ac3781 {

    /**
     * 乘车问题
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        while (f-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int prev = m;
            int ans = 1;
            for (int i = 0; i < n; i++) {
                if (prev >= arr[i]) {
                    prev -= arr[i];
                } else {
                    prev = m;
                    i--;
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
