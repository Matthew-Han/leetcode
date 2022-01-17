import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/14 09:07
 * @since 1.0
 **/
public class Ac1952 {

    /**
     * 金发姑娘和 N 头牛
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] fuck = sc.readLine().split(" ");
        int n = Integer.parseInt(fuck[0]);
        int x = Integer.parseInt(fuck[1]);
        int y = Integer.parseInt(fuck[2]);
        int z = Integer.parseInt(fuck[3]);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] sub = sc.readLine().split(" ");
            arr[i] = new int[]{Integer.parseInt(sub[0]), Integer.parseInt(sub[1])};
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[][] tmp = new int[n][3];
        for (int i = 0; i < n; i++) {
            int min = arr[i][1];
            int cnt0 = 0;
            int cnt1 = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][1] >= arr[i][0]) {
                    min = Math.min(min, arr[j][1]);
                    cnt0++;
                }

            }
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= min) {
                    cnt1++;
                    min = Math.min(min, arr[j][1]);
                } else {
                    break;
                }
            }
            tmp[i] = new int[]{i - cnt0, cnt0 + cnt1, n - cnt1 - i};
        }
        long ans = 0;
        for (int[] sub : tmp) {
            long curr = (long) sub[0] * z + (long) sub[1] * y + (long) sub[2] * x;
            ans = Math.max(ans, curr);

        }
        System.out.println(ans);


    }

}
