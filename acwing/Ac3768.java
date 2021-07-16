import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/16 09:32
 * @since 1.0
 **/
public class Ac3768 {

    /**
     * 字符串删减
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[] arr = sc.nextLine().toCharArray();
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'x') {
                cnt++;
            } else {
                if (cnt > 2) {
                    ans += cnt - 2;
                }
                cnt = 0;
            }
        }
        if (cnt > 2) {
            ans += cnt - 2;
        }
        System.out.println(ans);
    }
}
