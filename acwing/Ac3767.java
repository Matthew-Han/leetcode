import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/15 09:47
 * @since 1.0
 **/
public class Ac3767 {

    /**
     * 最小的值
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int cnt1 = 0;
        int cnt2 = 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1 && b[i] == 0) {
                cnt1++;
            }
            if (a[i] == 0 && b[i] == 1) {
                cnt2++;
            }
        }
        if (cnt1 > 0) {
            System.out.println((cnt2 % cnt1 == 0) ? (cnt2 / cnt1) : (cnt2 / cnt1) + 1);
        } else {
            System.out.println(-1);
        }
    }
}
