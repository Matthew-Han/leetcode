package 第9场周赛;

import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/26 09:52
 * @since 1.0
 **/
public class Ac3778 {

    /**
     * 平衡数组
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            if (k == 2) {
                System.out.println(1);
                System.out.println(2);
            } else {
                System.out.println(k);
                for (int i = 0; i < k; i++) {
                    System.out.print(i + 1 + " ");
                }
                System.out.println();
            }

        }
    }
}
