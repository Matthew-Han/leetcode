package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/4 18:00 04
 * @since 1.0
 **/
public class Ac800 {

    /**
     * 数组元素的目标和
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int a = Integer.parseInt(nk[0]);
        int b = Integer.parseInt(nk[1]);
        int k = Integer.parseInt(nk[2]);
        int[] s1 = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s2 = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = s1.length;
        int r = s2.length - 1;
        for (int i = 0; i < l; i++) {
            for (int j = r; j >= 0; j--) {
                if (s1[i] + s2[j] == k) {
                    System.out.println(i + " " + j);
                    return;
                } else if (s1[i] + s2[j] > k) {
                    r = j;
                } else {
                    break;
                }
            }
        }
    }
}
