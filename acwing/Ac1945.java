import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/17 09:15
 * @since 1.0
 **/
public class Ac1945 {

    /**
     * 奶牛棒球
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.readLine());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = i + 1; k < n; k++) {
                    if (arr[i] - arr[j] <= arr[k] - arr[i] && arr[k] - arr[i] <= 2 * (arr[i] - arr[j])) {
                        cnt++;
                    }
                    if (arr[k] - arr[i] > 2 * (arr[i] - arr[j])) {
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
