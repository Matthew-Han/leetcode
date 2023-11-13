import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/30 10:13
 * @since 1.0
 **/
public class Ac3731 {

    /**
     * 序列凑零
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < k; i += 2) {
                System.out.print(-a[i + 1] + " ");
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
