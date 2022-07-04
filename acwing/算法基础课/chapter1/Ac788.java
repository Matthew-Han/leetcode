package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/1 12:26 01
 * @since 1.0
 **/
public class Ac788 {

    static int[] cnt;
    static long ans = 0L;

    /**
     * 逆序对的数量
     * <p>
     * 很多人一开始可能会觉得你都排序了，还怎么算逆序对啊？其实利用归并排序「自底向上」的性质无需担心排好序后会影响结果，因为它是逐层返回的
     * <p>
     * 排好的 2 个子 sub 合并到一个大的父 sub，这个 sub 之间的逆序对已经算完了，他们和「后面位置」的 sub 还是保持着整个的初次的先后顺序
     * <p>
     * 所以我们只要每次计算左边的 sub 和右边的 sub 数组的逆序对就可以了。
     * <p>
     * 利用有序的性质，就可以得到「左边尾部」到「当前位置」的长度（也就是逆序对的个数）。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        sc.readLine();
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cnt = new int[arr.length];
        mergeSort(arr, 0, arr.length);
        System.out.println(ans);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r - 1) {
            return;
        }
        int m = (l + r) >>> 1;
        mergeSort(arr, l, m);
        mergeSort(arr, m, r);
        int[] tmp = new int[r - l];
        int a = l;
        int b = m;
        for (int i = 0; i < r - l; i++) {
            if (a >= m) {
                tmp[i] = arr[b++];
            } else if (b >= r) {
                tmp[i] = arr[a++];
            } else {
                boolean flag = arr[a] <= arr[b];
                ans += flag ? 0 : m - a;
                tmp[i] = flag ? arr[a++] : arr[b++];
            }
        }
        System.arraycopy(tmp, 0, arr, l, r - l);
    }

}
