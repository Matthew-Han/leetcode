import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/31 21:36 31
 * @since 1.0
 **/
public class Ac1884 {

    /**
     * COW
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        char[] arr = sc.readLine().toCharArray();
        int[] w = new int[n];
        long ans = 0;
        int prev = 0;
        w[n - 1] = arr[n - 1] == 'W' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            w[i] = w[i + 1] + (arr[i] == 'W' ? 1 : 0);
            if (arr[i] == 'O') {
                prev += w[i];
            }
            if (arr[i] == 'C') {
                ans += prev;
            }
        }
        System.out.println(ans);
    }
}
