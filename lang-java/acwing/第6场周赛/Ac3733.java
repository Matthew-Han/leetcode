package 第6场周赛;

import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/3 20:57
 * @since 1.0
 **/
public class Ac3733 {

    /**
     * 去掉一个元素
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            if (sum % 2 == 0) {
                ans++;
            }
            sum += arr[i];
        }
        System.out.println(ans);
    }

}
