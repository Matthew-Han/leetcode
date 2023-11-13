import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/31 18:08 31
 * @since 1.0
 **/
public class Ac1904 {


    /**
     * 奶牛慢跑
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] t = sc.readLine().split(" ");
            arr[i] = new int[]{Integer.parseInt(t[0]), Integer.parseInt(t[1])};
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int ans = 0;
        int point = arr[n - 1][1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i][1] <= point) {
                ans++;
                point = arr[i][1];
            }
        }
        System.out.println(ans + 1);
    }


}
