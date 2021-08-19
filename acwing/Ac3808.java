import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/19 10:27
 * @since 1.0
 **/
public class Ac3808 {

    /**
     * 画正方形
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int a = (int) Math.sqrt((double) k);
            int b = a;
            boolean flag = true;
            while (a * b < k) {
                if (flag) {
                    a++;
                } else {
                    b++;
                }
                flag = !flag;
            }
            System.out.println(a + b);
        }
    }
}
