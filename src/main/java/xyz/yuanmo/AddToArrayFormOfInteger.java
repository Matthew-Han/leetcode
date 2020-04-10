package xyz.yuanmo;

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
        AddToArrayFormOfInteger a = new AddToArrayFormOfInteger();
        int[] p = {1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3};
        a.addToArrayForm(p, 1);
    }

    public List<Integer> addToArrayForm(int[] arr, int k) {
        List<Integer> result = new ArrayList<>(16);
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a);
        }

        System.out.println(sb.toString());
        Long left = Long.valueOf(sb.toString());

        String[] list = String.valueOf(left + k).split("");
        for (String s : list) {
            result.add(Integer.valueOf(s));
        }
        System.out.println(result);

        return result;
    }

    private static String[] intToString(int[] arrs) {
        String[] s = new String[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            s[i] = String.valueOf(arrs[i]);
        }
        return s;

    }

}
