import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/27 11:26 27
 * @since 1.0
 **/
public class Ac1843 {

    /**
     * 圆形牛棚
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[] arr = new int[n];
        int sum = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.readLine());
            sum += arr[i];
            t += i * arr[i];
        }

        int ans = t;
        for (int i = 1; i < n; i++) {
            t = t - (sum - arr[i - 1]) + arr[i - 1] * (n - 1);
            ans = Math.min(ans, t);
        }
        System.out.println(ans);

    }
}
