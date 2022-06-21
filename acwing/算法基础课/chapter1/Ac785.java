package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/21 15:18 21
 * @since 1.0
 **/
public class Ac785 {

    /**
     * 快速排序
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        String[] t = sc.readLine().split(" ");
        int[] arr = new int[n];
        while (n-- > 0) {
            arr[arr.length - n - 1] = Integer.parseInt(t[arr.length - n - 1]);
        }
        quickSort(arr, 0, arr.length - 1);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void quickSort(int[] arr, int s, int e) {
        int l = s;
        int r = e;
        if (l >= r) {
            return;
        }
        int pivot = arr[l];
        while (l < r) {
            while (l < r && pivot <= arr[r]) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        quickSort(arr, s, l);
        quickSort(arr, l + 1, e);
    }

}
