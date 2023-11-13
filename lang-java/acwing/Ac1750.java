import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/4 18:48 04
 * @since 1.0
 **/
public class Ac1750 {

    /**
     * 前缀和、差分描述一段时间就是
     * l++, r--;
     * 而不是
     * l++, r + 1--;
     * <p>
     * 效果: 1 ~ 2; 3 ~ 4; 5 ~ 6
     * 就是 [0, 1, 0, 1, 0, 1]
     * 而不是 [0, 1, 1, 1, 1, 1]
     *
     * @param args
     * @throws IOException
     */
    public static void 带秀(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[][] arr = new int[n][2];
        // 差分数组
        int[] go = new int[1024];
        // 用于存储单个奶牛(不被其他奶牛覆盖)的工作区间,就是值 = 1 的时候
        int[] tmp = new int[1024];
        for (int i = 0; i < n; i++) {
            int[] curr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = curr;
            go[curr[0]]++;
            go[curr[1]]--;
        }
        int sum = go[0] > 0 ? 1 : 0;
        for (int i = 1; i < 1024; i++) {
            go[i] += go[i - 1];
            tmp[i] += tmp[i - 1] + (go[i] == 1 ? 1 : 0);
            sum += go[i] > 0 ? 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = arr[i][0];
            int r = arr[i][1];
            ans = Math.max(ans, sum - tmp[r - 1] + tmp[l - 1]);
        }
        System.out.println(ans);
    }


    /**
     * 救生员
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int[] curr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = curr;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, sumOfTheBeach(arr, i));
        }
        System.out.println(ans);
    }

    public static int sumOfTheBeach(int[][] arr, int idx) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i != idx) {
                pq.offer(new int[]{arr[i][0], arr[i][1]});
            }
        }

        int[] head = pq.poll();
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] <= head[1]) {
                head[1] = Math.max(curr[1], head[1]);
            } else {
                sum += head[1] - head[0];
                head = curr;
            }
        }
        sum += head[1] - head[0];
        return sum;

    }


}
