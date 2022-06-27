package 算法基础课.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/24 17:03 24
 * @since 1.0
 **/
public class Ac905 {

    /**
     * 区间选点
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
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int ans = 1;
        int r = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > r) {
                ans++;
                r = arr[i][1];
            } else {
                r = Math.min(r, arr[i][1]);
            }

        }
        System.out.println(ans);
    }

}
