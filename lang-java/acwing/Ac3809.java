import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/20 16:25
 * @since 1.0
 **/
public class Ac3809 {

    /**
     * 修改数组
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
            int min = 0x3f3f3f3f;
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            Arrays.sort(arr);
            int t = 0x3f3f3f3f;
            int ans = 0;
            for (int i = min; i <= max; i++) {
                int tmp = 0;
                for (int j = 0; j < k; j++) {
                    tmp += Math.max(Math.abs(i - arr[j]) - 1, 0);
                }
                if (tmp < t) {
                    t = tmp;
                    ans = i;
                }
            }
            System.out.println(ans + " " + t);
        }
    }


}
