package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/21 15:17 21
 * @since 1.0
 **/
public class Ac795 {

    /**
     * 前缀和
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int m = Integer.parseInt(nk[1]);
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum = new int[n];
        for (int i = 0; i < arr.length; i++) {
            sum[i] += (i - 1 >= 0 ? sum[i - 1] : 0) + arr[i];
        }
        for (int i = 0; i < m; i++) {
            String[] t = sc.readLine().split(" ");
            int l = Integer.parseInt(t[0]) - 1;
            int r = Integer.parseInt(t[1]) - 1;
            System.out.println(sum[r] - (l - 1 >= 0 ? sum[l - 1] : 0));
        }
    }
}
