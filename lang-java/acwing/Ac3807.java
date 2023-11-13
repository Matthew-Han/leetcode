import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/18 17:11
 * @since 1.0
 **/
public class Ac3807 {

    /**
     * 构造字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int t = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int i = 0; i < k; i++) {
                sb.append((char) ('a' + index++ % t));
            }
            System.out.println(sb);
        }
    }
}
