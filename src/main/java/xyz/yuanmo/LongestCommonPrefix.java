package xyz.yuanmo;

import java.util.*;

/**
 * @ClassName LongestCommonPrefix
 * @Description 最长公共前缀
 * @Author MatthewHan
 * @Date 2019/8/5 17:28
 * @Version 1.0
 **/
public class LongestCommonPrefix {

    public static void main(String[] args){
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"fdlow","flo","fld"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if("".equals(ans)) {
                return ans;
            }
        }
        return ans;
    }
}
