import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/6 11:05
 * @since 1.0
 **/
public class Ac3793 {

    /**
     * 最大分数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int max = 0;
            for (int i = 0; i < m; i++) {
                if (arr[i] >= 0) {
                    break;
                } else {
                    max += arr[i];
                }
            }
            System.out.println(-max);
        }
    }
}
