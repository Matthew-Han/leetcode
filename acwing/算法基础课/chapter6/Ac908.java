package 算法基础课.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/27 10:25 27
 * @since 1.0
 **/
public class Ac908 {

    /**
     * 最大不相交区间数量
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int prev = arr[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > prev) {
                ans++;
                prev = arr[i][1];
            }
        }
        System.out.println(ans);
    }
}
