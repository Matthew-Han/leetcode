package 第10场周赛;

import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:52
 * @since 1.0
 **/
public class Ac3787 {

    /**
     * 整除
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a <= b) {
                System.out.println(b - a);
            } else {
                if (a % b == 0) {
                    System.out.println(0);
                } else {
                    int t = a / b;
                    System.out.println((t + 1) * b - a);
                }
            }
        }
    }

}
