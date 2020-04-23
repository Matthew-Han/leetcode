package xyz.yuanmo;

import java.util.*;

/**
 * @ClassName AddBinary
 * @Description #67 二进制求和
 * @Author MatthewHan
 * @Date 2020/4/15 09:58
 * @Version 1.0
 **/
public class AddBinary {

    /**
     * 执行用时 : 83 ms , 在所有 Java 提交中击败了 6.38% 的用户
     * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 7.69% 的用户
     * 能再垃圾点吗？写完有点自闭了。
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        List<Integer> list1 = new ArrayList<>(maxLength);
        List<Integer> list2 = new ArrayList<>(maxLength);
        for (int i = 0; i < maxLength; i++) {
            if (i >= a.length()) {
                list1.add(0, 0);
            } else {
                list1.add(Integer.parseInt(a.split("")[i]));
            }
        }
        for (int i = 0; i < maxLength; i++) {
            if (i >= b.length()) {
                list2.add(0, 0);
            } else {
                list2.add(Integer.parseInt(b.split("")[i]));
            }
        }
        Integer[] result = new Integer[maxLength + 1];
        result[0] = 0;
        for (int i = 0; i < maxLength; i++) {
            result[i+1] = list1.get(i) + list2.get(i);
        }
        // 如果数组里的元素有2
        while (isHas2(result)) {
            for (int i = result.length - 1; i >= 0; i--) {
                if (result[i] == 2 && i - 1 >= 0) {
                    result[i] = 0;
                    result[i - 1] += 1;
                }
                if (result[i] == 3 && i - 1 >= 0) {
                    result[i] = 1;
                    result[i - 1] += 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && i == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
    public static boolean isHas2(Integer[] fuck) {
        for (Integer integer : fuck) {
            if (integer == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11100", "111"));
    }
}
