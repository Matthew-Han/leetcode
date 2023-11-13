package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/22 11:09 22
 * @since 1.0
 **/
public class Ac797 {

    /**
     * 差分
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] t = new int[n];
        for (int i = 0; i < m; i++) {
            int[] lrc = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            t[lrc[0] - 1] += lrc[2];
            if (lrc[1] < n) {
                t[lrc[1]] -= lrc[2];
            }
        }
        arr[0] += t[0];
        System.out.print(arr[0]);
        for (int i = 1; i < n; i++) {
            t[i] += t[i - 1];
            arr[i] += t[i];
            System.out.print(" " + arr[i]);
        }
    }

}
