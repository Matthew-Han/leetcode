import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/5 21:40 05
 * @since 1.0
 **/
public class Ac1738 {

    /**
     * 蹄球
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int[][] data = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            int idx = dfs(arr, i, new boolean[arr.length]);
            data[i] = new int[]{Math.min(idx, i), Math.max(idx, i)};
        }
        Arrays.sort(data, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        System.out.println(bfs(data));
    }

    public static int bfs(int[][] arr) {
        int ans = 1;
        int end = -1;
        int idx = 0;
        while (true) {
            int nxtIdx = idx;
            int nxtEnd = end;
            for (int i = idx; i < arr.length; i++) {
                if (arr[i][0] <= end + 1) {
                    if (arr[i][1] > end) {
                        nxtIdx = Math.max(i, nxtIdx);
                        nxtEnd = Math.max(arr[i][1], nxtEnd);
                    }
                } else {
                    break;
                }
                if (arr[i][1] == arr.length - 1) {
                    return ans;
                }
            }
            idx = nxtIdx;
            end = nxtEnd;
            ans++;
        }
    }

    public static int dfs(int[] arr, int idx, boolean[] vis) {
        vis[idx] = true;
        int nxt;
        if (idx == 0) {
            nxt = idx + 1;
        } else if (idx == arr.length - 1) {
            nxt = idx - 1;
        } else {
            nxt = arr[idx] - arr[idx - 1] <= arr[idx + 1] - arr[idx] ? idx - 1 : idx + 1;
        }
        if (!vis[nxt]) {
            return dfs(arr, nxt, vis);
        } else {
            return idx;
        }
    }
}
