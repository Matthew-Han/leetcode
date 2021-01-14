package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/14 11:43
 **/
public class PalindromePartitioning {


    /**
     * #131 分割回文串
     * 执行用时： 25 ms , 在所有 Java 提交中击败了 5.31% 的用户
     * 内存消耗： 53.7 MB , 在所有 Java 提交中击败了 6.74% 的用户
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if ("".equals(s)) {
            res.add(new ArrayList<>());
            return res;

        }

        for (int i = 1; i <= s.length(); i++) {
            String prev = s.substring(0, i);
            if (check(prev)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(prev);
                // System.out.println(prev);
                dfs(s, prev, i, tmp, res);
            }
        }
        return res;
    }

    public void dfs(String s, String prev, int index, List<String> tmp, List<List<String>> res) {
        if (index == s.length()) {
            res.add(tmp);
        }
        int max = s.length() - index;

        for (int j = 1; j <= max; j++) {
            List<String> next = new ArrayList<>(tmp);
            String curr = s.substring(index, index + j);
            if (check(curr)) {
                next.add(curr);
                dfs(s, curr, index + j, next, res);
            }
        }
    }

    /**
     * StringBuilder 翻转性能一般
     * 还是采用数组计算比较好一点
     *
     * @param s
     * @return
     */
    public boolean check(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println("4".charAt(0) - '0');
    }
}
