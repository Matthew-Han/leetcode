import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/12 09:05
 * @since 1.0
 **/
public class Ac1978 {

    /**
     * 奶牛过马路
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] maxArr = new int[n];
        int[] minArr = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i][1]);
            maxArr[i] = max;
        }
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, arr[i][1]);
            minArr[i] = min;

        }
        for (int i = 0; i < n; i++) {
            if (arr[i][1] >= maxArr[i] && arr[i][1] <= minArr[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
