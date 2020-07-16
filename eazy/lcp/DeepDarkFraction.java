package lcp;

import java.util.Arrays;

/**
 * @ClassName DeepDarkFraction
 * @Description #LCP 02 分式化简
 * @Author MatthewHan
 * @Date 2020/7/15 17:54
 * @Version 1.0
 **/
public class DeepDarkFraction {

    public static int[] fraction(int[] cont) {
        int len = cont.length;
        // cont长度为1时直接返回
        if (len == 1) {
            return new int[]{cont[0], 1};
        }

        // 计算分式结果
        int[] arr = new int[]{1, cont[len - 1]};
        for (int i = len - 2; i >= 0; i--) {
            arr = handler(cont[i], arr);
        }
        int n = arr[1];
        int m = arr[0];

        // 分数化简
        int gcd = gcd(n, m);
        return new int[]{n / gcd, m / gcd};
    }

    // 计算1/(a + arr[0]/arr[1])
    public static int[] handler(int a, int[] arr) {
        return new int[]{arr[1], a * arr[1] + arr[0]};
    }

    // 计算最大公约数
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(fraction(new int[]{5, 1, 0, 6, 1, 7, 2, 6, 6, 4})));

    }
}
