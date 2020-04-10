package xyz.yuanmo;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ImplementStrStr
 * @Description #28 实现 strStr()
 * 创造了超时最多的纪录
 * @Author MatthewHan
 * @Date 2020/4/10 10:05
 * @Version 1.0
 **/
public class ImplementStrStr {

    /**
     * 该算法基本上可以实现LeetCode的题目
     * 但是超时。。👴服了
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

        for (int i=0; i<haystackArray.length; i++) {
            int trueNum = 0;
            // 小串的开头每次都先匹配大串
            if (haystackArray[i].equals(needleArray[0])) {
                // 变量x不会侵入i，大串的for循环
                int x = i;
                for (String s : needleArray) {
                    // 防止大串的数组下标越界
                    if (x<haystackArray.length && s.equals(haystackArray[x++])) {
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
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
