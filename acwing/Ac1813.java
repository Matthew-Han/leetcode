import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/1 14:01 01
 * @since 1.0
 **/
public class Ac1813 {


    /**
     * 方块游戏
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            String[] t = sc.readLine().split(" ");
            char[] arr0 = t[0].toCharArray();
            char[] arr1 = t[1].toCharArray();
            int[] vis0 = new int[26];
            int[] vis1 = new int[26];
            for (char c : arr0) {
                vis0[c - 'a']++;
            }
            for (char c : arr1) {
                vis1[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                arr[j] += Math.max(vis0[j], vis1[j]);
            }
        }
        for (int sout : arr) {
            System.out.println(sout);
        }

    }

}
