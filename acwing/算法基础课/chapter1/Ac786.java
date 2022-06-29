package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/29 14:53 29
 * @since 1.0
 **/
public class Ac786 {

    /**
     * 第 K 个数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(fuck(arr, 0, nk[0] - 1, nk[1] - 1));
    }

    public static int fuck(int[] arr, int l, int r, int k) {
        int nxtL = l;
        int nxtR = r;
        int p = l;
        while (l < r) {
            while (l < r) {
                if (arr[r] < arr[p]) {
                    arr[r] ^= arr[p];
                    arr[p] ^= arr[r];
                    arr[r] ^= arr[p];
                    p = r;
                    break;
                }
                r--;
            }
            while (l < r) {
                if (arr[l] > arr[p]) {
                    arr[l] ^= arr[p];
                    arr[p] ^= arr[l];
                    arr[l] ^= arr[p];
                    p = l;
                    break;
                }
                l++;
            }
        }
        if (p == k) {
            return arr[p];
        } else if (p < k) {
            return fuck(arr, p + 1, nxtR, k);
        } else {
            return fuck(arr, nxtL, p - 1, k);
        }
    }
}
