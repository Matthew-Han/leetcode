package 第10场周赛;

import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:52
 * @since 1.0
 **/
public class Ac3788 {

    /**
     * 截断数组
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int start = arr[0];
        sum -= start;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (start == sum) {
                ans++;
            }
            start += arr[i];
            sum -= arr[i];
        }
        System.out.println(ans);
    }
}
