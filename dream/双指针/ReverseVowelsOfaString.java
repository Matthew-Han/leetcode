package 双指针;

import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName 双指针.ReverseVowelsOfaString
 * @Description #345 反转字符串中的元音字母
 * @Author MatthewHan
 * @Date 2020/5/9 10:02
 * @Version 1.0
 **/
public class ReverseVowelsOfaString {


    /**
     * 执行用时 : 24 ms , 在所有 Java 提交中击败了 6.99% 的用户
     * 内存消耗 : 45.7 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param s
     * @return
     */
    public static String reverseVowelsPro(String s) {

        List<Integer> list = new ArrayList<>(s.length());
        // 将字符串中的元音字符的【下标】取出保存到list中
        for (int i = 0; i < s.length(); i++) {
            if (isVowels(String.valueOf(s.charAt(i)))) {
                list.add(i);
            }
        }
        String[] result = s.split("");
        int left = 0;
        int right = list.size() - 1;
        // 利用list元音字符【下标】来操作数组交换位置，双指针交换
        while (left < right) {
            String temp = result[list.get(left)];
            result[list.get(left)] = result[list.get(right)];
            result[list.get(right)] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (String s1 : result) {
            sb.append(s1);
        }
        return sb.toString();
    }

    /**
     * 执行用时 : 25 ms , 在所有 Java 提交中击败了 6.88% 的用户
     * 内存消耗 : 45.9 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        String[] arrays = s.split("");
        List<String> list = new ArrayList<>(s.length());
        List<String> vowelList = new ArrayList<>(s.length());
        int j = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (isVowels(arrays[i])) {
                list.add(i, null);
                vowelList.add(arrays[i]);
            } else {
                list.add(arrays[i]);
            }
        }

        Collections.reverse(vowelList);
        for (int i = 0; i < list.size(); i++) {
            if (null == list.get(i)) {
                list.set(i, vowelList.get(j));
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    public static boolean isVowels(String s) {
        return "AaEeIiOoUu".contains(s);
    }


    public static void main(String[] args) {
        System.out.println(reverseVowelsPro("leetcodeIsMyTest"));
    }
}
