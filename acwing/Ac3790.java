import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/4 10:56
 * @since 1.0
 **/
public class Ac3790 {

    /**
     * 录入单词
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > c) {
                ans = 1;
            } else {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
