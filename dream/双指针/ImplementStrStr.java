package 双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 双指针.ImplementStrStr
 * @Description #28 实现 strStr()
 * @Author MatthewHan
 * @Date 2020/4/10 10:05
 * @Version 1.0
 **/
public class ImplementStrStr {

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 13.13% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 39.91% 的用户
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        if (needle == null) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack == null || "".equals(haystack)) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int len = needle.length();
        char head = needle.charAt(0);
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == head) {
                indexList.add(i);
            }
        }
        System.out.println("indexList = " + indexList);
        for (Integer integer : indexList) {
            if (integer + len <= haystack.length() && haystack.substring(integer, integer + len).equals(needle)) {
                return integer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("mississippi", "issipi"));
    }

    /**
     * 该算法基本上可以实现
     * 但是超时。。👴服了
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        String[] haystackArray = haystack.split("");
        String[] needleArray = needle.split("");

        for (int i = 0; i < haystackArray.length; i++) {
            int trueNum = 0;
            // 小串的开头每次都先匹配大串
            if (haystackArray[i].equals(needleArray[0])) {
                // 变量x不会侵入i，大串的for循环
                int x = i;
                for (String s : needleArray) {
                    // 防止大串的数组下标越界
                    if (x < haystackArray.length && s.equals(haystackArray[x++])) {
                        trueNum++;
                    }
                    if (trueNum == needleArray.length) {
                        return x - trueNum;
                    }
                }
            }
        }
        return -1;
    }


}
