package leetcode.eazy;

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


    /**
     * 该方法超时时间限制。。。
     * @param A
     * @param K
     * @return
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int value : A) {
            stringBuilder.append(value);
        }
        stringBuilder.reverse();
        Integer[] left = new Integer[A.length];
        for (int i = 0; i < stringBuilder.toString().split("").length; i++) {
            left[i] = Integer.parseInt(stringBuilder.toString().split("")[i]);
        }

        String[] k1 = String.valueOf(K).split("");
        Integer[] right = new Integer[k1.length];
        int l = 0;
        for (int i = right.length - 1; i >= 0; i--) {
            right[i] = Integer.parseInt(k1[l]);
            l++;
        }

        int size = Math.max(left.length, right.length) + 1;
        Integer[] result = new Integer[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = (i < left.length ? left[i] : 0) + (i < right.length ? right[i] : 0);
        }


        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] >= 10) {
                result[i] = result[i] - 10;
                result[i + 1]++;
            }
        }

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

    public static void main(String[] args) {
        int[] p = {1,2,0,0};
        System.out.println("addToArrayForm(p, 143) = " + addToArrayForm(p, 34));
    }

}
