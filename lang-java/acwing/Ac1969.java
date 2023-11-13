import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/12 09:20
 * @since 1.0
 **/
public class Ac1969 {


    /**
     * 品种邻近
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.readLine());
        }
        Map<Integer, Integer> ids = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            if (ids.containsKey(arr[i]) && ids.get(arr[i]) + k >= i) {
                set.add(arr[i]);
            }
            ids.put(arr[i], i);
        }
        for (Integer ans : set) {
            System.out.println(ans);
            return;
        }
        System.out.println(-1);
    }

}
