import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/4 11:07
 * @since 1.0
 **/
public class Ac2041 {

    /**
     * 干草堆
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n + 1];
        for (int i = 0; i < k; i++) {
            String[] tmp = sc.readLine().split(" ");
            arr[Integer.parseInt(tmp[0]) - 1]++;
            arr[Integer.parseInt(tmp[1])]--;
        }

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        Arrays.sort(arr, 0, n);
        System.out.println(arr[n / 2]);

    }
}
