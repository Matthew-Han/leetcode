import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/2 23:25 02
 * @since 1.0
 **/
public class Ac1762 {

    /**
     * 牛的洗牌
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(1134903170);
        System.out.println((int)1E9);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[] t = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sort = new int[n];
        for (int i = 0; i < n; i++) {
            sort[t[i] - 1] = i;
        }
        String[] arr = sc.readLine().split(" ");
        arr = dfs(3, sort, arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static String[] dfs(int cnt, int[] sort, String[] arr) {
        if (cnt == 0) {
            return arr;
        }
        String[] nxt = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nxt[sort[i]] = arr[i];
        }
        return dfs(cnt - 1, sort, nxt);
    }

}
