import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/11 17:24
 * @since 1.0
 **/
public class Ac3799 {

    /**
     * 送糖果
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            boolean flag = true;
            int tmp = 1;
            while (true) {
                if (flag) {
                    a -= tmp++;
                    if (a < 0) {
                        System.out.println("Vladik");
                        break;
                    }
                } else {
                    b -= tmp++;
                    if (b < 0) {
                        System.out.println("Valera");
                        break;
                    }
                }
                flag = !flag;
            }
        }
    }
}
