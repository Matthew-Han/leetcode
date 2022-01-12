import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/10 10:10
 * @since 1.0
 **/
public class Ac1987 {

    /**
     * 6
     * 2 R
     * 6 L
     * 1 R
     * 8 L
     * 1 R
     * 2 R
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        List<int[]> arr = new ArrayList<>();
        String[] interval = sc.readLine().split(" ");
        int l = "L".equals(interval[1]) ? -Integer.parseInt(interval[0]) : 0;
        int r = "L".equals(interval[1]) ? 0 : Integer.parseInt(interval[0]);
        int curr = "L".equals(interval[1]) ? -Integer.parseInt(interval[0]) : Integer.parseInt(interval[0]);
        String prev = interval[1];
        for (int i = 0; i < n - 1; i++) {
            interval = sc.readLine().split(" ");
            int size = Integer.parseInt(interval[0]);
            int start = curr;
            int end = curr;
            if ("L".equals(interval[1])) {
                curr -= size;
                start = curr;
            } else {
                curr += size;
                end = curr;
            }
            // 出现两次的条件
            if (!prev.equals(interval[1]) || start > l || end < r) {
                int[] p = new int[]{Math.max(start, l), Math.min(end, r)};
                arr.add(p);
            }
            prev = interval[1];
            l = Math.min(l, start);
            r = Math.max(r, end);

        }

        arr.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> fuck = new ArrayList<>();
        int[] prevArr = {arr.get(0)[0], arr.get(0)[1]};
        for (int i = 1; i < arr.size(); i++) {
            if (prevArr[1] >= arr.get(i)[0]) {
                prevArr[1] = Math.max(prevArr[1], arr.get(i)[1]);
            } else {
                fuck.add(prevArr);
                prevArr = arr.get(i);
            }
            if (i == arr.size() - 1) {
                fuck.add(prevArr);
            }
        }
        int cnt = 0;
        for (int[] ints : fuck) {

            cnt += ints[1] - ints[0];

        }

        System.out.println(cnt);

    }

}
