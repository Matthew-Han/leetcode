import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/2 23:04 02
 * @since 1.0
 **/
public class Ac1776 {


    /**
     * 牛的基因组学
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        char[][] arr = new char[2 * n][k];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.readLine().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            boolean flag = true;
            int[] vis = new int[26];
            for (int j = 0; j < n; j++) {
                vis[arr[j][i] - 'A']++;
            }
            for (int j = n; j < 2 * n; j++) {
                if (vis[arr[j][i] - 'A'] > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}
