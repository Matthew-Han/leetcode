import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/9 11:01
 * @since 1.0
 **/
public class Ac3794 {

    /**
     * 构造字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String template = "abba";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(template.charAt(i % template.length()));
        }
        System.out.println(sb);
    }
}
