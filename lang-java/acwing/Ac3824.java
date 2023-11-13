import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/31 10:13
 * @since 1.0
 **/
public class Ac3824 {

    /**
     * 在校时间
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < k; i++) {
                if (arr[i] == 1) {
                    ans++;
                    if (i + 2 < k && arr[i + 1] == 0 && arr[i + 2] == 1) {
                        ans++;
                        i++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
