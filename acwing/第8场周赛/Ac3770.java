package 第8场周赛;

import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/17 18:56
 * @since 1.0
 **/
public class Ac3770 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();
            char[] arr = sc.nextLine().toCharArray();
            int ans = 0;
            for (int i = 0; i < k; i++) {
                if (arr[i] == '0') {
                    ans += Math.min(b + c, a);
                } else {
                    ans += Math.min(a + c, b);
                }
            }
            System.out.println(ans);
        }
    }
}
