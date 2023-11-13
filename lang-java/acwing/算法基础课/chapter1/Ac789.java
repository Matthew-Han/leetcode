package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/1 16:45 01
 * @since 1.0
 **/
public class Ac789 {

    /**
     * 数的范围
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (k-- > 0) {
            int idx = Integer.valueOf(sc.readLine());
            System.out.println(binarySearch(arr, 0, n - 1, idx, true) + " " + binarySearch(arr, 0, n - 1, idx, false));
        }
    }

    public static int binarySearch(int[] arr, int l, int r, int k, boolean left) {
        while (l <= r) {
            int mid = l + r >> 1;
            if (arr[mid] < k) {
                l = mid + 1;
            } else if (arr[mid] > k) {
                r = mid - 1;
            } else {
                if (left) {
                    if (mid == 0 || arr[mid - 1] != k) {
                        return mid;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (mid == arr.length - 1 || arr[mid + 1] != k) {
                        return mid;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
