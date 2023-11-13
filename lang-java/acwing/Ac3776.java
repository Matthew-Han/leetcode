import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/23 09:50
 * @since 1.0
 **/
public class Ac3776 {

    /**
     * 水果拼盘
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int max = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            int f = sc.nextInt();

            if (e >= f) {
                if (a > 0 && d > 0) {
                    int fuck = Math.min(a, d);
                    d -= fuck;
                    max += e * fuck;
                }
                if (b > 0 && c > 0 && d > 0) {
                    int fuck = Math.min(b, Math.min(c, d));
                    max += f * fuck;
                }
            } else {
                if (b > 0 && c > 0 && d > 0) {
                    int fuck = Math.min(b, Math.min(c, d));
                    d -= fuck;
                    max += f * fuck;
                }
                if (a > 0 && d > 0) {
                    int fuck = Math.min(a, d);
                    max += e * fuck;
                }
            }
            System.out.println(max);
        }
    }

}
