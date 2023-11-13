import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:45
 * @description
 * @since 1.0.0
 **/
public class Ac3547 {

    /**
     * 特殊数字
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = plus(n);
        while (true) {
            if (sum % 4 == 0) {
                System.out.println(n);
                return;
            }
            n++;
            sum = plus(n);
        }
    }

    public static int plus(int tmp) {
        int sum = 0;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }
}
