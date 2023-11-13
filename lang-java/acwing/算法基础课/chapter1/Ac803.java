package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/24 16:06 24
 * @since 1.0
 **/
public class Ac803 {


    /**
     * 区间合并
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
        int[] prev = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] <= prev[1]) {
                prev = new int[]{prev[0], Math.max(prev[1], arr[i][1])};
            } else {
                ans++;
                prev = arr[i];
            }
        }
        System.out.println(ans);
    }

}
