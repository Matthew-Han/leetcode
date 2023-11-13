import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/13 10:37
 * @since 1.0
 **/
public class Ac1960 {

    /**
     * 闪烁
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nb = sc.readLine().split(" ");
        int n = Integer.parseInt(nb[0]);
        long b = Long.parseLong(nb[1]);
        int[] startArr = new int[n];
        for (int i = 0; i < n; i++) {
            startArr[i] = Integer.parseInt(sc.readLine());
        }
        fuck(startArr, n);

        if (b < staticList0.size()) {
            for (int v : staticList0.get((int) b)) {
                System.out.println(v);
            }
        } else {
            b -= staticList0.size();
            b %= staticList1.size();
            for (int v : staticList1.get((int) b)) {
                System.out.println(v);
            }
        }
    }


    /**
     * 前面一段不重复的
     */
    static List<int[]> staticList0 = new ArrayList<>();
    /**
     * 后面重复的
     */
    static List<int[]> staticList1 = new ArrayList<>();

    static void fuck(int[] arr, int x) {

        Map<String, Integer> set = new HashMap<>();
        List<int[]> v = new ArrayList<>();
        set.put(Arrays.toString(arr), 0);
        v.add(arr.clone());
        int idx = 1;
        while (true) {
            int[] tmp = new int[x];
            for (int i = 1; i <= x; i++) {
                if (arr[i - 1] == 1) {
                    tmp[i % x] = 1 - arr[i % x];
                } else {
                    tmp[i % x] = arr[i % x];
                }
            }
            System.arraycopy(tmp, 0, arr, 0, x);
            if (set.containsKey(Arrays.toString(arr))) {

                int start = set.get(Arrays.toString(arr));

                for (int i = 0; i < start; i++) {
                    staticList0.add(v.get(i));
                }


                for (int i = start; i < v.size(); i++) {
                    staticList1.add(v.get(i));
                }

                break;
            } else {
                v.add(tmp);
            }
            set.put(Arrays.toString(arr), idx);
            idx++;

        }
    }

}
