package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/29 17:01 29
 * @since 1.0
 **/
public class Ac787 {

    /**
     * 归并排序
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        sc.readLine();
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        mergeSort(arr, 0, arr.length);
        for (int n : arr) {
            System.out.print(n + " ");
        }

    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r - 1) {
            return;
        }
        int m = (l + r) >>> 1;
        mergeSort(arr, l, m);
        mergeSort(arr, m, r);
        int[] tmp = new int[r - l];
        int left = l;
        int right = m;
        for (int i = 0; i < r - l; i++) {
            if (left >= m) {
                tmp[i] = arr[right++];
                continue;
            }
            if (right >= r) {
                tmp[i] = arr[left++];
                continue;
            }
            if (arr[left] <= arr[right]) {
                tmp[i] = arr[left++];
            } else {
                tmp[i] = arr[right++];
            }
        }
        System.arraycopy(tmp, 0, arr, l, r - l);
    }

}
