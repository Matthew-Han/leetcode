import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/16 09:43
 * @since 1.0
 **/
public class Ac3801 {

    /**
     * 最佳连续子数组
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            int max = 0xc0c0c0c0;
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }
            int len = 1;
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                if (arr[i] == max) {
                    cnt++;
                } else {
                    len = Math.max(len, cnt);
                    cnt = 0;
                }
            }
            len = Math.max(len, cnt);
            System.out.println(len);
        }
    }
}
