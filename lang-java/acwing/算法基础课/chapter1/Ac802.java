package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/24 09:19 24
 * @since 1.0
 **/
public class Ac802 {

    /**
     * 区间和
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int m = Integer.parseInt(nk[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            int[] xc = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.put(xc[0], map.getOrDefault(xc[0], 0) + xc[1]);
        }
        int prev = 0;
        int minK = Integer.MAX_VALUE;
        int maxK = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            minK = Math.min(e.getKey(), minK);
            maxK = Math.max(e.getKey(), maxK);
            int v = e.getValue();
            e.setValue(v + prev);
            prev += v;
        }
        for (int i = 0; i < m; i++) {
            int[] lr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map.Entry<Integer, Integer> t1 = map.lowerEntry(lr[0]);
            Map.Entry<Integer, Integer> t2 = map.floorEntry(lr[1]);
            int left = t1 == null ? 0 : t1.getValue();
            int right = t2 == null ? map.get(maxK) : t2.getValue();
            System.out.println(right - left);
        }
    }

}
