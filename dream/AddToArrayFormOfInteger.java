import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AddToArrayFormOfInteger
 * @Description #989 数组形式的整数加法
 * @Author MatthewHan
 * @Date 2019/8/9 09:06
 * @Version 1.0
 **/
public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
        int[] p = {0};
        System.out.println(addToArrayFormPro(p, 0));
    }

    /**
     * 2020.6.30再次来做，进步很多~
     * <p>
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 98.86% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @param k
     * @return
     */
    public static List<Integer> addToArrayFormPro(int[] a, int k) {
        // 计算整数的长度，特殊情况：0的长度是1
        int kLen = k == 0 ? 1 : (int) (Math.log10(k)) + 1;
        int[] kArr = new int[kLen];
        int n = kLen - 1;
        while (k > 0) {
            int temp = k % 10;
            kArr[n] = temp;
            k /= 10;
            n--;
        }
        // 额外数组所需要的容量大小，需要加1，可能存在进位
        int len = Math.max(a.length, kArr.length);
        int[] result = new int[len + 1];
        int temp = len;
        for (int i = a.length - 1; i >= 0; i--) {
            result[temp] = a[i];
            temp--;
        }
        for (int i = kArr.length - 1; i >= 0; i--) {
            result[len] += kArr[i];
            len--;
        }
        // 额外数组全部相加之后，处理大于9的元素，进位的进位
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] > 9) {
                result[i] %= 10;
                result[i - 1] += 1;
            }
        }
        List<Integer> list = new ArrayList<>(result.length);

        for (int i = 0; i < result.length; i++) {
            // 首位为0，本次跳过
            if (i == 0 && result[0] == 0) {
                continue;
            }
            list.add(result[i]);
        }
        return list;
    }


    /**
     * 该方法LeetCode判定超时。。。
     *
     * @param a
     * @param k
     * @return
     */
    public static List<Integer> addToArrayForm(int[] a, int k) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int value : a) {
            stringBuilder.append(value);
        }
        stringBuilder.reverse();
        Integer[] left = new Integer[a.length];
        for (int i = 0; i < stringBuilder.toString().split("").length; i++) {
            left[i] = Integer.parseInt(stringBuilder.toString().split("")[i]);
        }
        System.out.println(Arrays.toString(left));

        String[] k1 = String.valueOf(k).split("");
        Integer[] right = new Integer[k1.length];
        int l = 0;
        for (int i = right.length - 1; i >= 0; i--) {
            right[i] = Integer.parseInt(k1[l]);
            l++;
        }
        System.out.println(Arrays.toString(right));

        /* ======================================================= */
        int size = Math.max(left.length, right.length) + 1;
        Integer[] result = new Integer[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = (i < left.length ? left[i] : 0) + (i < right.length ? right[i] : 0);
        }
        System.out.println(Arrays.toString(result));


        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] >= 10) {
                result[i] = result[i] - 10;
                result[i + 1]++;
            }
        }
        System.out.println(Arrays.toString(result));

        /* ======================================================= */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i != result.length - 1 || (i == result.length - 1 && result[result.length - 1] != 0)) {
                sb.append(result[i]);
            }
        }
        sb.reverse();
        List<Integer> fucker = new ArrayList<>(result.length);
        for (String s : sb.toString().split("")) {
            fucker.add(Integer.parseInt(s));
        }
        return fucker;
    }


}
